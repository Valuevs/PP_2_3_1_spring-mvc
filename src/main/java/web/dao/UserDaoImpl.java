package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getByIdUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }
}
