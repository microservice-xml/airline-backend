package com.example.airlinebackend.service;

import com.example.airlinebackend.model.City;
import com.example.airlinebackend.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City findByName(String name) {
        return cityRepository.findByName(name);
    }

    public City addNewCity(City city) {
        return cityRepository.save(city);
    }
}
