package jason.app.socailcapital.web.controller;

import jason.app.socailcapital.web.model.WebUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SimpleSecurityInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory
            .getLogger(HomeController.class);
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        return true;
    }

    public boolean preHandle2(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        logger.debug("preHandle");
        HttpSession session = request.getSession();
        boolean loginStatus = false;
        if(session!=null) {
            WebUser webUser = (WebUser) session.getAttribute("LOGIN_USER");
            if(webUser!=null) {
                loginStatus = true;
            }
        }
        boolean anonymousAllowed = false;
        if(request.getRequestURI().startsWith(request.getContextPath()+"/spring/signin")) {
            anonymousAllowed =  true;
        }
        if(request.getRequestURI().startsWith(request.getContextPath()+"/spring/signup")) {
            anonymousAllowed =  true;
        }
        
        if(!loginStatus && !anonymousAllowed) {
            response.sendRedirect(request.getContextPath()+"/spring/signin");
            return false;
        }
            
       return true;
    }
}
