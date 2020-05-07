package com.mkaiho.learning.spring.gracefulshutdownapp.infrastructure.datasources.user;

import com.mkaiho.learning.spring.gracefulshutdownapp.domain.models.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAllSlowly();
}
