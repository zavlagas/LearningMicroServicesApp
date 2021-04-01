package com.microserviceapp.rest.webservices.services;

import com.microserviceapp.rest.webservices.daos.UserDao;
import com.microserviceapp.rest.webservices.exceptionhandlers.UserNotFoundException;
import com.microserviceapp.rest.webservices.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public List<User> findAll() {
        return dao.getAll();
    }

    @Override
    public User save(User user) {
        return dao.save(user);
    }

    @Override
    public Optional<User> find(int id) {
        return dao.find(id);
    }

    @Override
    public Optional<User> deleteById(int id) {
        Optional<User> userForDelete = find(id);
        if (userForDelete.isPresent()) {
            dao.deleteById(id);
        }
        return userForDelete;
    }
}
