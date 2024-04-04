package org.bootcampspringboot.junitandmockito.resources;

import org.bootcampspringboot.junitandmockito.domain.dto.UserDTO;
import org.bootcampspringboot.junitandmockito.domain.entites.User;
import org.bootcampspringboot.junitandmockito.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    public static final String ID = "/{Id}";
    @Autowired
    private ModelMapper mapper;

    @Autowired
    public UserService service;


    @GetMapping(value = ID)
    public ResponseEntity<UserDTO> findById (@PathVariable Integer Id){
        return ResponseEntity.ok().body(mapper.map(service.findById(Id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok()
                .body(service.findAll()
                        .stream().map(UserDTO::new)
                        .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO obj){
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path(ID)
                .buildAndExpand(service.create(obj).getId()).toUri()).build();
    }

    @PutMapping(value = ID)
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO obj, @PathVariable Integer Id){
        obj.setId(Id);
        return ResponseEntity.ok().body(mapper.map(service.update(obj),UserDTO.class));
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<UserDTO> delete(@PathVariable Integer Id){
        service.delete(Id);
        return ResponseEntity.noContent().build();
    }

}
