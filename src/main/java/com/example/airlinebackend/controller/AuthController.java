package com.example.airlinebackend.controller;

import com.example.airlinebackend.auth.AuthenticationRequest;
import com.example.airlinebackend.auth.AuthenticationResponse;
import com.example.airlinebackend.auth.AuthenticationService;
import com.example.airlinebackend.model.User;
import com.example.airlinebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User newUser){
        return ResponseEntity.ok(service.register(newUser));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
