package com.example.airlinebackend.controller;

import com.example.airlinebackend.dto.FlightDto;
import com.example.airlinebackend.model.ApiKey;
import com.example.airlinebackend.model.User;
import com.example.airlinebackend.service.ApiKeyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/api-key")
@RequiredArgsConstructor
public class ApiKeyController {

    private final ApiKeyService apiKeyService;

    @GetMapping
    public List<ApiKey> getAll() {
        return apiKeyService.getAll();
    }

    @GetMapping("/user/{userId}")
    public List<ApiKey> getAllByUserId(@PathVariable("userId") String userId){
        return apiKeyService.getAllByUserId(userId);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody ApiKey apiKey) {
        apiKeyService.add(apiKey);
        return ResponseEntity.ok().build();
    }

}
