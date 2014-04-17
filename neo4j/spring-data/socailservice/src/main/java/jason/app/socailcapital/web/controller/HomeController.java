package jason.app.socailcapital.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.examples.hellograph.GalaxyService;
import org.springframework.data.neo4j.examples.hellograph.domain.World;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController {


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
	//	  World myWorld = galaxyService.createWorld("mine", 0);
		return "home";
	}
	
	/**
     * Selects the home page and populates the model with a message
     */
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(Model model) {
        logger.info("Welcome home!");
        model.addAttribute("controllerMessage",
                "This is the message from the controller!");
    //    World myWorld = galaxyService.createWorld("mine", 0);
        return "signin";
    }
	

}
