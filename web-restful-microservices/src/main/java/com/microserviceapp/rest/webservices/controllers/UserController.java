package com.microserviceapp.rest.webservices.controllers;

import com.microserviceapp.rest.webservices.exceptionhandlers.UserNotFoundException;
import com.microserviceapp.rest.webservices.models.User;
import com.microserviceapp.rest.webservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    //retrieveAllUsers
    @GetMapping
    private List<User> retrieveAllUsers() {
        return (service.findAll());
    }


    //retrieveUser(int id)
    @GetMapping("/{id}")
    private User retrieveUser(@PathVariable int id) {
        Optional<User> retrievedUser = service.find(id);
        if (retrievedUser.isEmpty()) {
            throw new UserNotFoundException("id-" + id);
        }
        return retrievedUser.get();
    }

    //createUser(User user)
    @PostMapping
    private ResponseEntity create(@RequestBody User user) {
        User savedUser = service.save(user);


        /*Return "http://localhost:8080/users/savedUser.getId"
                new URI-Link from new User*/
        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
