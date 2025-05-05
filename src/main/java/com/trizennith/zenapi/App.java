package com.trizennith.zenapi;

import com.trizennith.zenapi.datasources.jpa.entities.Role;
import com.trizennith.zenapi.datasources.jpa.entities.User;
import com.trizennith.zenapi.datasources.jpa.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            var userEmailSample = "zennith@karilith.com";
            logger.info("CommandLineRunner started");

            if (userRepository.findByEmail(userEmailSample).isEmpty()) {
                logger.info("Creating user with email: {}", userEmailSample);
                User user = new User();
                user.setFullName("Zen Nith");
                user.setEmail(userEmailSample);
                user.setPassword(passwordEncoder.encode("password"));
                user.setRole(Role.ROLE_USER);
                userRepository.save(user);
            }

        };
    }

}
