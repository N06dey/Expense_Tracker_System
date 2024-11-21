package com.evc.expense_tracker.DAO;

import com.evc.expense_tracker.entity.User;

import java.util.List;

public interface UserDAO {

    // Creating New User
    User saveUser(User user);

    // Finding User by User ID
    User findByUserId(Long id);

    // Finding User by UserName
    User findByUsername(String username);

    // Checking all Users
    List<User> findAllUser();

    // Deleting Users
    void deleteByUserId(Long id);
}
