package org.bootcampspringboot.junitandmockito.services.impl;

import org.bootcampspringboot.junitandmockito.domain.entites.User;
import org.bootcampspringboot.junitandmockito.repositories.UserRepository;
import org.bootcampspringboot.junitandmockito.services.UserService;
import org.bootcampspringboot.junitandmockito.services.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository repository;

    @Override
    public User findById(Integer Id) {
        Optional<User> obj = repository.findById(Id);
        return obj.orElseThrow(() -> new UserNotFoundException("User not found!"));
    }
}
