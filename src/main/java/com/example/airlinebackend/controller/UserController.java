package com.example.airlinebackend.controller;

import com.example.airlinebackend.auth.AuthenticationRequest;
import com.example.airlinebackend.auth.AuthenticationResponse;
import com.example.airlinebackend.auth.AuthenticationService;
import com.example.airlinebackend.model.User;
import com.example.airlinebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/email/{email}")
    public User findByEmail(@PathVariable("email") String email){ return userService.findByEmail(email).get(); }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id){
        return userService.findById(id);
    }


}
