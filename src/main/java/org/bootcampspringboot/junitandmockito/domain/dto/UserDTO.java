package org.bootcampspringboot.junitandmockito.domain.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bootcampspringboot.junitandmockito.domain.entites.User;

import java.util.Objects;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer Id;

    private String name;

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    public UserDTO(User user){
        this.Id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

}
