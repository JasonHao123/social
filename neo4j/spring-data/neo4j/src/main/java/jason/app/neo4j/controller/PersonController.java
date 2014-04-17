package jason.app.neo4j.controller;

import jason.app.neo4j.dao.PersonDao;
import jason.app.neo4j.model.DBPerson;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/person/")
public class PersonController {
    
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonDao personDao;
	
	@RequestMapping(method=RequestMethod.GET,value="edit")
	public ModelAndView editPerson(@RequestParam(value="id",required=false) Long id) {		
		logger.debug("Received request to edit person id : "+id);				
		ModelAndView mav = new ModelAndView();		
 		mav.setViewName("edit");
 		DBPerson person = null;
 		if (id == null) {
 			person = new DBPerson();
 		} else {
 			person = personDao.find(id);
 		}
 		
 		mav.addObject("person", person);
		return mav;
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="edit") 
	public String savePerson(@ModelAttribute DBPerson person) {
		logger.debug("Received postback on person "+person);		
		personDao.save(person);
		return "redirect:list";
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="list")
	public ModelAndView listPeople() {
		logger.debug("Received request to list persons");
		ModelAndView mav = new ModelAndView();
		List<DBPerson> people = personDao.getPeople();
		logger.debug("Person Listing count = "+people.size());
		mav.addObject("people",people);
		mav.setViewName("list");
		return mav;
		
	}

}
