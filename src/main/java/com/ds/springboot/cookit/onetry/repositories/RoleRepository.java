package com.ds.springboot.cookit.onetry.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ds.springboot.cookit.onetry.entities.Role;

public interface RoleRepository extends CrudRepository <Role, Long>{
    Optional<Role> findByName(String name);
}
