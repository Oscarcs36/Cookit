package com.ds.springboot.cookit.onetry.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ds.springboot.cookit.onetry.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
