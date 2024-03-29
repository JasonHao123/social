package org.neo4j.cineasts.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.neo4j.cineasts.domain.Actor;
import org.neo4j.cineasts.domain.Movie;
import org.neo4j.cineasts.domain.Rating;
import org.neo4j.cineasts.domain.User;
import org.neo4j.cineasts.repository.ActorRepository;
import org.neo4j.cineasts.repository.MovieRepository;
import org.neo4j.cineasts.repository.UserRepository;
import org.neo4j.cineasts.service.DatabasePopulator;
import org.neo4j.helpers.collection.IteratorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mh
 * @since 04.03.11
 */
@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    Neo4jOperations template;
    @Autowired
    private DatabasePopulator populator;
    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    /**
     * Only matches 'GET /moviies/{id}}' requests for JSON content; a 404 is sent otherwise.
     * TODO send a 406 if an unsupported representation, such as XML, is requested.  See SPR-7353.
     */
    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public
    @ResponseBody
    Movie getMovie(@PathVariable String id) {
        return movieRepository.findById(id);
    }


    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.GET, headers = "Accept=text/html")
    public String singleMovieView(final Model model, @PathVariable String movieId) {
        User user = addUser(model);
        Movie movie = movieRepository.findById(movieId);
        model.addAttribute("id", movieId);
        if (movie != null) {
            model.addAttribute("movie", movie);
            final int stars = movie.getStars();
            model.addAttribute("stars", stars);
            Rating rating = null;
            if (user!=null) rating = template.getRelationshipBetween(movie, user, Rating.class, "RATED");
            if (rating == null) rating = new Rating().rate(stars,null);
            model.addAttribute("userRating",rating);
        }
        return "/movies/show";
    }

    @RequestMapping(value = "/movies/{movieId}", method = RequestMethod.POST, headers = "Accept=text/html")
    public String updateMovie(Model model, @PathVariable String movieId, @RequestParam(value = "rated",required = false) Integer stars, @RequestParam(value = "comment",required = false) String comment) {
        Movie movie = movieRepository.findById(movieId);
        User user = userRepository.getUserFromSession();
        if (user != null && movie != null) {
            int stars1 = stars==null ? -1 : stars;
            String comment1 = comment!=null ? comment.trim() : null;
            userRepository.rate(movie, user, stars1, comment1);
        }
        return singleMovieView(model,movieId);
    }

    private User addUser(Model model) {
        User user = userRepository.getUserFromSession();
        model.addAttribute("user", user);
        return user;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET, headers = "Accept=text/html")
    public String findMovies(Model model, @RequestParam("q") String query) {
        Iterator iter = movieRepository.findAll().iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        if (query!=null && !query.isEmpty()) {
            Page<Movie> movies = movieRepository.findByTitleLike(query, new PageRequest(0, 20));
            model.addAttribute("movies", movies.getContent());
        } else {
            model.addAttribute("movies", Collections.emptyList());
        }
        model.addAttribute("query", query);
        addUser(model);
        return "/movies/list";
    }

    @RequestMapping(value = "/actors/{id}", method = RequestMethod.GET, headers = "Accept=text/html")
    public String singleActorView(Model model, @PathVariable String id) {
        Actor actor = actorRepository.findById(id);
        model.addAttribute("actor", actor);
        model.addAttribute("id", id);
        model.addAttribute("roles",  IteratorUtil.asCollection(actor.getRoles()));
        addUser(model);
        return "/actors/show";
    }

    //@RequestMapping(value = "/admin/populate", method = RequestMethod.GET)
    @RequestMapping(value = "/populate", method = RequestMethod.GET)
    public String populateDatabase(Model model) {
        Collection<Movie> movies=populator.populateDatabase();
        model.addAttribute("movies",movies);
        addUser(model);
        return "/movies/list";
    }

    @RequestMapping(value = "/admin/clean", method = RequestMethod.GET)
    public String clean(Model model) {
        populator.cleanDb();
        return "movies/list";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        addUser(model);
        return "index";
    }
}
