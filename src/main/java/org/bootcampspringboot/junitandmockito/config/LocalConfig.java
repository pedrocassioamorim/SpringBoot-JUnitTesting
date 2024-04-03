package org.bootcampspringboot.junitandmockito.config;

import org.bootcampspringboot.junitandmockito.domain.entites.User;
import org.bootcampspringboot.junitandmockito.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB(){
        User u1 = new User(null, "Pedro", "amorim@pedro", "123");
        User u2 = new User(null, "Cássio", "amorim@cassio", "123");

        repository.saveAll(List.of(u1, u2));
    }
}

