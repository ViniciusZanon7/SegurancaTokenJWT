package com.security.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.dto.LoginRequest;
import com.example.security.model.User;
import com.example.security.repository.UserRepository;

@Service
public class AuthService {

    private final UserRepository repository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository repository,
                       JwtService jwtService,
                       BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(LoginRequest request) {

        User user = repository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(request.password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(user.getEmail(), user.getRole());
    }
}