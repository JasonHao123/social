package jason.app.socialcapital.dao.impl;

import jason.app.socialcapital.dao.UserDao;
import jason.app.socialcapital.entity.ProviderUser;
import jason.app.socialcapital.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public void createProviderUser(ProviderUser providerUser) {
        entityManager.persist(providerUser);

    }

    public ProviderUser findProviderUser(String providerId, String uid) {
        Query query = entityManager.createNamedQuery("provider.findById");
        query.setParameter("providerId", providerId);
        query.setParameter("providerUserId", uid);
        try {
            return (ProviderUser) query.getSingleResult();
        }catch(NoResultException e) {
            return null;
        }
    }

    public User findUserById(Long id) {
        // TODO Auto-generated method stub
        return entityManager.find(User.class, id);
    }

}
