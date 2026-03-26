package com.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.security.dto.LoginRequest;
import com.example.security.dto.LoginResponse;
import com.example.security.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String token = service.login(request);
        return ResponseEntity.ok(new LoginResponse(token));
    }
}