package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "cc")
public record ContentCalendarProperties(String welcomeMessage, String about) {
}
