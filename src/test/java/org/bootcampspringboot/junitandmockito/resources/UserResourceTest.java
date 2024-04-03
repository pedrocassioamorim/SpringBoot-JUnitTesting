package org.bootcampspringboot.junitandmockito.resources;

import org.bootcampspringboot.junitandmockito.domain.dto.UserDTO;
import org.bootcampspringboot.junitandmockito.domain.entites.User;
import org.bootcampspringboot.junitandmockito.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserResourceTest {

    @InjectMocks
    private UserResource resource;

    @Mock
    private UserService service;

    @Mock
    private ModelMapper mapper;

    private static final Integer ID = 1;
    private static final String name = "Pedro Dias";
    private static final String email = "amorim@dias";
    private static final String password = "123";
    private static final String userNotFoundInDb = "User not found in DB";
    private static final String emailOnDB = "E-mail already on database";

    private User user;

    private UserDTO userDTO;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User(ID, name, email, password);
        userDTO = new UserDTO(ID, name, email, password);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}