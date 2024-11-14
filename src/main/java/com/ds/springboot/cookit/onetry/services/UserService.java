package com.ds.springboot.cookit.onetry.services;

import java.util.List;
import java.util.Optional;

import com.ds.springboot.cookit.onetry.entities.User;

public interface UserService {
    List<User> listAll();

    Optional<User> findById(Long id);
    
    User save(User user);

    Optional<User> update(Long id, User user);
    
    Optional<User> delete(Long id);

    boolean existsByEmail(String email);
}
