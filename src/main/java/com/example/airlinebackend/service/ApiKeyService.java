package com.example.airlinebackend.service;

import com.example.airlinebackend.model.ApiKey;
import com.example.airlinebackend.repository.ApiKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;

    public List<ApiKey> getAll() {
        return apiKeyRepository.findAll();
    }

    public List<ApiKey> getAllByUserId(String userId) {
        return apiKeyRepository.findAllByUserId(userId);
    }

    public void add(ApiKey apiKey) {
        apiKey.setKey(String.valueOf(UUID.randomUUID()));
        apiKeyRepository.insert(apiKey);
    }
}
