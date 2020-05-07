package com.mkaiho.learning.spring.gracefulshutdownapp.infrastructure.datasources.user;

import com.mkaiho.learning.spring.gracefulshutdownapp.application.repositories.UserRepository;
import com.mkaiho.learning.spring.gracefulshutdownapp.domain.models.user.User;
import com.mkaiho.learning.spring.gracefulshutdownapp.domain.models.user.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataSource implements UserRepository {
    private final UserMapper userMapper;

    public UserDataSource(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Users findAllUsersSlowly() {
        List<User> users = this.userMapper.findAllSlowly();
        return new Users(users);
    }
}
