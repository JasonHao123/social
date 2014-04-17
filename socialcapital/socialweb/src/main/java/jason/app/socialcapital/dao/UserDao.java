package jason.app.socialcapital.dao;

import jason.app.socialcapital.entity.ProviderUser;
import jason.app.socialcapital.entity.User;


public interface UserDao {
    public User createUser(User user);

    public void createProviderUser(ProviderUser providerUser);

    public ProviderUser findProviderUser(String providerId, String uid);

    public User findUserById(Long id);
}
