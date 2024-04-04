package org.bootcampspringboot.junitandmockito.services;

import org.bootcampspringboot.junitandmockito.domain.dto.UserDTO;
import org.bootcampspringboot.junitandmockito.domain.entites.User;

import java.util.List;

public interface UserService {
     User findById(Integer id);

     List<User> findAll();

     User create(UserDTO obj);

     User update(UserDTO obj);

     void delete(Integer Id);
}
