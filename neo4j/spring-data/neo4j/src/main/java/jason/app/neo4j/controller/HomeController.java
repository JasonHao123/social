package jason.app.neo4j.controller;

import static org.junit.Assert.assertEquals;
import jason.app.neo4j.domain.World;
import jason.app.neo4j.service.GalaxyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {
    
    @Autowired
    private GalaxyService galaxyService;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Welcome home!");
		model.addAttribute("controllerMessage",
				"This is the message from the controller!");
		

        World myWorld = galaxyService.createWorld("mine", 0);
      
        Iterable<World> foundWorlds = galaxyService.getAllWorlds();
        World mine = foundWorlds.iterator().next();
        model.addAttribute("controllerMessage",
                "This is the message from the controller!"+mine.getName());
        

		return "home";
	}
	

}
