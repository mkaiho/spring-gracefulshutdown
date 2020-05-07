package com.mkaiho.learning.spring.gracefulshutdownapp.domain.models.user;

import java.util.UUID;

public class UserId {
    private String value;

    public UserId() {
        this.value = UUID.randomUUID().toString();
    }

    public UserId(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(UserId other) {
        if (other == null) {
            return false;
        }
        return value.equals(other.value);
    }
}
