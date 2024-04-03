package org.bootcampspringboot.junitandmockito.services;

import org.bootcampspringboot.junitandmockito.domain.entites.User;

public interface UserService {
     User findById(Integer id);
}
