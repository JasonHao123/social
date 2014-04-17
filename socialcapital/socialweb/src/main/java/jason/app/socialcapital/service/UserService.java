package jason.app.socialcapital.service;

import jason.app.socialcapital.web.model.WebProviderUser;
import jason.app.socialcapital.web.model.WebUser;

public interface UserService {
    public void createUser(WebUser user);

    public WebProviderUser getProviderUser(String string, String uid);

    public void createProviderUser(WebProviderUser providerUser);
    
    public WebUser getUserById(Long id);
}
