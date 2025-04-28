

package web.dao;

import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import web.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public void updateUser(Long id, User user) {
        User us = entityManager.find(User.class, id);
        if (user != null) {
            us.setFirstName(user.getFirstName());
            us.setLastName(user.getLastName());
            us.setEmail(user.getEmail());
            entityManager.merge(us);
        }
    }

    @Override
    public User showUser(Long id) {
        return entityManager.find(User.class, id);
    }
}
