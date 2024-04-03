package org.bootcampspringboot.junitandmockito.domain.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bootcampspringboot.junitandmockito.domain.entites.User;

import java.util.Objects;

public class UserDTO {

    private Integer Id;

    private String name;

    private String email;

    @JsonIgnore
    private String password;

    public UserDTO(Integer id, String name, String email, String password) {
        this.Id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDTO (){}

    public UserDTO(User user){
        this.Id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO userDTO)) return false;
        return Objects.equals(Id, userDTO.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
