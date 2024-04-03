package org.bootcampspringboot.junitandmockito.resources;

import org.bootcampspringboot.junitandmockito.domain.entites.User;
import org.bootcampspringboot.junitandmockito.repositories.UserRepository;
import org.bootcampspringboot.junitandmockito.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    public UserService service;


    @GetMapping(value = "/{Id}")
    public ResponseEntity<User> findById (@PathVariable Integer Id){
        return ResponseEntity.ok().body(service.findById(Id));
    }

}
