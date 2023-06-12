package com.example.airlinebackend.repository;

import com.example.airlinebackend.model.ApiKey;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApiKeyRepository extends MongoRepository<ApiKey, String> {
    List<ApiKey> findAllByUserId(String userId);
}
