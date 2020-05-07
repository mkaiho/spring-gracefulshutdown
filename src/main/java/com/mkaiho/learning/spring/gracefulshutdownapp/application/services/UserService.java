package com.mkaiho.learning.spring.gracefulshutdownapp.application.services;

import com.mkaiho.learning.spring.gracefulshutdownapp.application.repositories.UserRepository;
import com.mkaiho.learning.spring.gracefulshutdownapp.domain.models.user.User;
import com.mkaiho.learning.spring.gracefulshutdownapp.domain.models.user.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final String MESSAGE_TEMPLATE = "USER NAME: {}";
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Scheduled(cron = "${cron.user.echo-name}", zone = "${cron.zone}")
    public void echoUserName() {
        LOGGER.info("=== BEGIN ===");

        Users users = this.userRepository.findAllUsersSlowly();

        if (users.isEmpty()) {
            LOGGER.info("not exists.");
        }
        for (User user : users.getList()) {
            LOGGER.info(MESSAGE_TEMPLATE, user.getName());
        }

        LOGGER.info("=== END ===");
    }
}
