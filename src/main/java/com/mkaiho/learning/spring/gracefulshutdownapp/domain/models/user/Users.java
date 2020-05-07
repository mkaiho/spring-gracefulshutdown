package com.mkaiho.learning.spring.gracefulshutdownapp.domain.models.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    public List<User> list;

    public Users(List<User> list) {
        if (list == null) {
            this.list = new ArrayList<>();
        } else {
            this.list = list;
        }
    }

    public List<User> getList() {
        return this.list.stream().collect(Collectors.toList());
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }
}
