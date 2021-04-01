package com.microserviceapp.rest.webservices.daos;

import com.microserviceapp.rest.webservices.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {


    List<User> getAll();

    User save(User user);

    Optional<User> find(int id);

}
