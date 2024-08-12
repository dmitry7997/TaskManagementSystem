package com.app.TaskManagementSystem.security.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix =  "jwt")
public class JWTConfiguration {

    public Long expiration;

    public String secret;
}
