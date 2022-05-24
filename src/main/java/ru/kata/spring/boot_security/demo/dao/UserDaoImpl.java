package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }


    @Override
    public void removeUser(long id) {
        entityManager.remove(getUserById(id));
    }


    @Override
    public void editUser(User user) {
        entityManager.merge(user);
    }


    @Override
    public User getUserByEmail(String email) {
        return  entityManager.createQuery("select u from User u where u.email = ?1", User.class)
                .setParameter(1, email)
                .getSingleResult();
    }
}
