package com.example.airlinebackend.Service;

import com.example.airlinebackend.Exception.NotFoundException;
import com.example.airlinebackend.Model.User;
import com.example.airlinebackend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User add(User user){
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User doesn't exist"));
    }
}
