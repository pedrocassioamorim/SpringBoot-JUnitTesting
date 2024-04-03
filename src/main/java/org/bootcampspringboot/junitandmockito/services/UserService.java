package org.bootcampspringboot.junitandmockito.services;

import org.bootcampspringboot.junitandmockito.domain.entites.User;

import java.util.List;

public interface UserService {
     User findById(Integer id);

     List<User> findAll();
}
