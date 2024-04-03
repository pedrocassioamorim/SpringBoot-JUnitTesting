package org.bootcampspringboot.junitandmockito.resources;

import org.bootcampspringboot.junitandmockito.domain.dto.UserDTO;
import org.bootcampspringboot.junitandmockito.domain.entites.User;
import org.bootcampspringboot.junitandmockito.repositories.UserRepository;
import org.bootcampspringboot.junitandmockito.services.UserService;
import org.modelmapper.ModelMapper;
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
    private ModelMapper mapper;

    @Autowired
    public UserService service;


    @GetMapping(value = "/{Id}")
    public ResponseEntity<UserDTO> findById (@PathVariable Integer Id){
        return ResponseEntity.ok().body(mapper.map(service.findById(Id), UserDTO.class));
    }

}
