package com.trizennith.zenapi.controllers;

import com.trizennith.zenapi.datasources.jpa.entities.User;
import com.trizennith.zenapi.dtos.LoginResponse;
import com.trizennith.zenapi.dtos.LoginUserDto;
import com.trizennith.zenapi.dtos.RegisterUserDto;
import com.trizennith.zenapi.services.AuthenticationService;
import com.trizennith.zenapi.services.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto, HttpServletRequest request) {
        log.info("Authenticating user: {}", loginUserDto);
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);

        saveSession(request, jwtToken, authenticatedUser);

        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    private void saveSession(HttpServletRequest request, String jwtToken, User user) {
        String ip = (request.getRemoteAddr() != null && !request.getRemoteAddr().isEmpty()) ?
                request.getRemoteAddr() : request.getHeader("X-Forwarded-For");
        String userAgent = request.getHeader("User-Agent");

        jwtService.saveSession(ip, userAgent, jwtToken, user);
    }
}