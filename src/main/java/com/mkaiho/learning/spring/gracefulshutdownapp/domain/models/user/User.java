package com.mkaiho.learning.spring.gracefulshutdownapp.domain.models.user;

public class User {
    private UserId id;
    private String name;

    private User() {
    }

    public User(String name) {
        this(new UserId(), name);
    }

    public User(UserId id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserId getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
