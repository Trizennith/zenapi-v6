package com.trizennith.zenapi.services;


import com.trizennith.zenapi.datasources.jpa.entities.User;
import com.trizennith.zenapi.datasources.jpa.repositories.UserRepository;
import com.trizennith.zenapi.dtos.LoginUserDto;
import com.trizennith.zenapi.dtos.RegisterUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        User user = new User();
        user.setFullName(input.fullName());
        user.setEmail(input.email());
        user.setPassword(passwordEncoder.encode(input.password()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        log.info("Authenticating user with email: {}", input.email());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );


        return userRepository.findByEmail(input.email())
                .orElseThrow();
    }


}