package com.mkaiho.learning.spring.gracefulshutdownapp.application.configurations;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@ConditionalOnProperty(name = "scheduler.enable", havingValue = "true")
@EnableScheduling
@Configuration
public class SchedulerConfiguration {
}
