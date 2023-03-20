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

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User newUser){
        if(!userService.findByEmail(newUser.getEmail()).isEmpty()){
            return ResponseEntity.badRequest().body("Email already used.");
        }else {
            return ResponseEntity.ok(service.register(newUser));
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
