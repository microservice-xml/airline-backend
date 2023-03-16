package com.example.airlinebackend.service;

import com.example.airlinebackend.exception.NotFoundException;
import com.example.airlinebackend.model.User;
import com.example.airlinebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User add(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User doesn't exist"));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).get();
    }
}
