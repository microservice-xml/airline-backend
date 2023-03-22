package com.example.airlinebackend.repository;

import com.example.airlinebackend.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<City, String> {

    City findByName(String name);
}
