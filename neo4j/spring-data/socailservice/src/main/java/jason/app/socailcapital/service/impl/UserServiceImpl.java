package jason.app.socailcapital.service.impl;

import jason.app.socailcapital.dao.UserDao;
import jason.app.socailcapital.entity.User;
import jason.app.socailcapital.service.UserService;
import jason.app.socailcapital.web.model.WebUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    public void createUser(WebUser webUser) {
        User user = new User();
        user.setUsername(webUser.getUsername());
        user.setPassword(webUser.getPassword());
        user.setDisplayName(webUser.getDisplayName());
        user = userDao.createUser(user);
        webUser.setId(user.getId());
    }

}
