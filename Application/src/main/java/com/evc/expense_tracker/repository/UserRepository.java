package com.evc.expense_tracker.repository;
import com.evc.expense_tracker.DAO.UserDAO;
import com.evc.expense_tracker.entity.User;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepository implements UserDAO {
    EntityManager entityManager;

    @Autowired
    UserRepository(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User findByUserId(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public List<User> findAllUser() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteByUserId(Long id) {
        User user = findByUserId(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
