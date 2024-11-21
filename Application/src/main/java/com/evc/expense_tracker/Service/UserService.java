package com.evc.expense_tracker.Service;
import com.evc.expense_tracker.entity.User;
import com.evc.expense_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepo;

    @Autowired
    UserService(UserRepository userRepo){
        this.userRepo=userRepo;
    }

    public User registerUser(User user) {
        return userRepo.saveUser(user);
    }

    public List<User> getallUser(){
        return userRepo.findAllUser();
    }

    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}

