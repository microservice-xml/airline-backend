package com.example.airlinebackend.controller;

import com.example.airlinebackend.auth.AuthenticationRequest;
import com.example.airlinebackend.auth.AuthenticationResponse;
import com.example.airlinebackend.auth.AuthenticationService;
import com.example.airlinebackend.model.User;
import com.example.airlinebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationService service;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable("email") String email){ return userService.findByEmail(email); }

    @PostMapping("/register")
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id){
        return userService.findById(id);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
