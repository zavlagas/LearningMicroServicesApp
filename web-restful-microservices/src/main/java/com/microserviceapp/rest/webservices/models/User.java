package com.microserviceapp.rest.webservices.models;

import java.time.LocalDate;

public class User {

    private final int id;
    private final String name;
    private final LocalDate birthDate;
  

    private User(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public static User create(int id, String name, LocalDate localDate) {
        return (new User(id, name, localDate));
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
