package jason.app.socailcapital.dao.impl;

import jason.app.socailcapital.dao.UserDao;
import jason.app.socailcapital.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
