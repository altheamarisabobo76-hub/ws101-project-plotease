package com.plotease.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plotease.model.User;
import com.plotease.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User signup(User user) {
        return repo.save(user);
    }

    public User login(String email, String password) {
        Optional<User> user = repo.findByEmail(email);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null;
    }
}