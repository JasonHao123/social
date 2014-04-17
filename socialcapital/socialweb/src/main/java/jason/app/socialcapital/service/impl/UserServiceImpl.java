package jason.app.socialcapital.service.impl;

import jason.app.socialcapital.dao.UserDao;
import jason.app.socialcapital.entity.ProviderUser;
import jason.app.socialcapital.entity.User;
import jason.app.socialcapital.service.UserService;
import jason.app.socialcapital.socialcommon.service.GalaxyService;
import jason.app.socialcapital.web.model.WebProviderUser;
import jason.app.socialcapital.web.model.WebUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private GalaxyService galaxyService;
    
    public void createUser(WebUser webUser) {
        User user = new User();
        user.setUsername(webUser.getUsername());
        user.setPassword(webUser.getPassword());
        user.setDisplayName(webUser.getDisplayName());
        user = userDao.createUser(user);
        webUser.setId(user.getId());
        galaxyService.createWorld("test", 3);
    }

    public WebProviderUser getProviderUser(String providerId, String uid) {
        // TODO Auto-generated method stub
        WebProviderUser webProviderUser = null;
        ProviderUser providerUser =  userDao.findProviderUser(providerId,uid);
        if(providerUser!=null) {
            webProviderUser = new WebProviderUser();
            webProviderUser.setProviderId(providerUser.getProviderId());
            webProviderUser.setProviderUserId(providerUser.getProviderUserId());
            webProviderUser.setUser(getUserById(providerUser.getUserId()));
        }
        return webProviderUser;
    }

    public void createProviderUser(WebProviderUser webProviderUser) {
        ProviderUser providerUser = new ProviderUser();
        providerUser.setProviderId(webProviderUser.getProviderId());
        providerUser.setUserId(webProviderUser.getUser().getId());
        providerUser.setProviderUserId(webProviderUser.getProviderUserId());
        userDao.createProviderUser(providerUser);
        
    }

    public WebUser getUserById(Long id) {
        WebUser webUser = null;
        User user = userDao.findUserById(id);
        if(user!=null) {
            webUser = new WebUser();
            webUser.setId(user.getId());
            webUser.setUsername(user.getUsername());
            webUser.setDisplayName(user.getDisplayName());
        }
        return webUser;
    }

}
