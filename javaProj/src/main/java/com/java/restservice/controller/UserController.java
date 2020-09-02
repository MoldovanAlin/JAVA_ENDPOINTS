package com.java.restservice.controller;

import com.java.restservice.exception.ResourceNotFoundException;
import com.java.restservice.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.restservice.model.User;
import com.java.restservice.repository.UserRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private Utils utils;

    @GetMapping
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{username}")
    public void find(@PathVariable("username") String username) throws ResourceNotFoundException {
        if (!userRepository.exists(username)) {
            throw new ResourceNotFoundException("User not found for this id :: " + username);
        }
        userRepository.findOne(username);
    }

    @PostMapping(consumes = "application/json")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping(path = "/{username}")
    public void delete(@PathVariable("username") String username) {
        userRepository.delete(username);
    }

    @PutMapping(path = "/{username}")
    public void update(@PathVariable("username") String username, @RequestBody User user) throws BadHttpRequest, ResourceNotFoundException {
        if (!userRepository.exists(username)) {
            throw new ResourceNotFoundException("User not found for this id :: " + username);
        } else {
            User currentUser = userRepository.findOne(username);
            if (currentUser.getSavings() != null) {
                //savings already exists
                throw new BadHttpRequest();
            } else {
                if (utils.checkDate() || utils.checkHours()) {
                    currentUser.setSavings(user.getSavings());
                    userRepository.save(currentUser);
                }

            }

        }
    }
}