package org.bootcampspringboot.junitandmockito;

import org.bootcampspringboot.junitandmockito.services.exceptions.UserNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JUnitAndMockitoApplication {

    public static void main(String[] args) {

        SpringApplication.run(JUnitAndMockitoApplication.class, args);

        UserNotFoundException user = new UserNotFoundException("User not in Database");

        System.out.println(user.getMessage());
    }

}
