package jason.app.socailcapital.web.controller;

import jason.app.socailcapital.service.UserService;
import jason.app.socailcapital.web.model.WebUser;
import jason.app.socailcapital.web.validator.WebUserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {
    
    private final Validator validator = new WebUserValidator();
    
    @Autowired
    private UserService userService;
    
    private static final Logger logger = LoggerFactory
            .getLogger(SignUpController.class);
    
    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public ModelAndView displayWelcomePage() {
     
       ModelAndView model = new ModelAndView("signup", "webUser", new WebUser());
     
       return model;
    }
    
    
    /**
     * Selects the home page and populates the model with a message
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String postSignUp(HttpServletRequest request,HttpSession session,WebUser form, BindingResult result) {
        logger.info("Welcome home!");
        validator.validate(form, result);
        if (result.hasErrors()) {
            form.setPassword("");
            form.setPasswordAgain("");         
            return "signup";
        }
        try {
            userService.createUser(form);
           session.setAttribute("LOGIN_USER", form);
        } catch (Exception e) {
            e.printStackTrace();
            result.rejectValue("username", "validate.err.unexpected", e.getMessage());
            form.setPassword("");
            form.setPasswordAgain("");
            return "signup";
        }
        
        return "redirect:/spring/signin";
    }
}
