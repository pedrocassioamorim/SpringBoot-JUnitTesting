package org.bootcampspringboot.junitandmockito.domain.entites;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Getter @Setter
@AllArgsConstructor
@Entity(name = "tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer Id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;


    public User() {}
}
