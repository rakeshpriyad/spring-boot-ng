package com.test.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}
