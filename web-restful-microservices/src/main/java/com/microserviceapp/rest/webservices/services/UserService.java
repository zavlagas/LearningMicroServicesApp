package com.microserviceapp.rest.webservices.services;

import com.microserviceapp.rest.webservices.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User save(User user);

    Optional<User> find(int id);
}
