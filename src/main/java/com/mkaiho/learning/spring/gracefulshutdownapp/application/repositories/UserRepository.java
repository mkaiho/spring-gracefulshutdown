package com.mkaiho.learning.spring.gracefulshutdownapp.application.repositories;

import com.mkaiho.learning.spring.gracefulshutdownapp.domain.models.user.Users;

public interface UserRepository {
    Users findAllUsersSlowly();
}
