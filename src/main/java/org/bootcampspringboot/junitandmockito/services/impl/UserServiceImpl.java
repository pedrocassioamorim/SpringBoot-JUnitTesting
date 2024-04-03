package org.bootcampspringboot.junitandmockito.services.impl;

import org.bootcampspringboot.junitandmockito.domain.dto.UserDTO;
import org.bootcampspringboot.junitandmockito.domain.entites.User;
import org.bootcampspringboot.junitandmockito.repositories.UserRepository;
import org.bootcampspringboot.junitandmockito.services.UserService;
import org.bootcampspringboot.junitandmockito.services.exceptions.DataIntegratyViolationException;
import org.bootcampspringboot.junitandmockito.services.exceptions.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer Id) {
        Optional<User> obj = repository.findById(Id);
        return obj.orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return repository.save(mapper.map(obj,User.class));
    }

    @Override
    public void delete(Integer Id) {
        findById(Id);
        repository.deleteById(Id);
    }


    private void findByEmail(UserDTO obj){
        Optional<User> user = repository.findByEmail(obj.getEmail());
        if (user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegratyViolationException("E-mail already on database");
        }
    }
}
