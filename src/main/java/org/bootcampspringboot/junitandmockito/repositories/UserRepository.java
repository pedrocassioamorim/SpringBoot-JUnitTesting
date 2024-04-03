package org.bootcampspringboot.junitandmockito.repositories;

import org.bootcampspringboot.junitandmockito.domain.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
