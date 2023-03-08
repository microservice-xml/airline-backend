package com.example.airlinebackend.controller;

import com.example.airlinebackend.model.User;
import com.example.airlinebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id){
        return userService.findById(id);
    }
}
