package com.ds.springboot.cookit.onetry.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.springboot.cookit.onetry.entities.Role;
import com.ds.springboot.cookit.onetry.entities.User;
import com.ds.springboot.cookit.onetry.repositories.RoleRepository;
import com.ds.springboot.cookit.onetry.repositories.UserRepository;

@Service
public class UserServiceJPA implements UserService{

    @Autowired
    UserRepository repository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> listAll() {
        List<User> users = (List<User>) repository.findAll();

        return users;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        Optional<User> optionalUser = repository.findById(id);

        return optionalUser;
    }

    @Override
    @Transactional
    public User save(User user) {
        Optional<Role> optionalRole = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        optionalRole.ifPresent(roles::add);

        if(user.isAdmin()){
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }

        user.setRoles(roles);
        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        
        return repository.save(user);
    }

    @Override
    @Transactional
    public Optional<User> delete(Long id) {
        Optional<User> userOptional = repository.findById(id);

        userOptional.ifPresent(userDb -> {
            repository.delete(userDb);
        });

        return userOptional;
    }

    @Override
    @Transactional
    public Optional<User> update(Long id, User user) {
        Optional<User> userOptional = repository.findById(id);

        if(userOptional.isPresent()){
            User userDb = userOptional.orElseThrow();
            
            userDb.setName(user.getName());
            userDb.setLastName(user.getLastName());
            userDb.setEmail(user.getEmail());
            userDb.setAboutMe(user.getAboutMe());
            userDb.setProfilePicture(user.getProfilePicture());

            return Optional.of(repository.save(userDb));
        }

        return userOptional;
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

}
