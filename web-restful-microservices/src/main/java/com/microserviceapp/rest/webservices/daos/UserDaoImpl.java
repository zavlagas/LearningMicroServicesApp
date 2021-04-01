package com.microserviceapp.rest.webservices.daos;

import com.microserviceapp.rest.webservices.models.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(User.create(1, "Nick", LocalDate.of(1995, 4, 29)));
        users.add(User.create(2, "Peter", LocalDate.of(2000, 11, 2)));
        users.add(User.create(3, "Kate", LocalDate.of(1987, 10, 15)));
    }


    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User save(User user) {
        if (user.getId() == 0) {
            user = User.create(++userCount, user.getName(), user.getBirthDate());
            users.add(user);
            return user;
        } else {
            return (User.create(0, "User Exists", LocalDate.now()));
        }

    }

    @Override
    public Optional<User> find(int id) {
        return (
                users.stream()
                        .filter(user -> user.getId() == id)
                        .findFirst()
        );
    }
}
