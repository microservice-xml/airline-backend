package com.example.airlinebackend.controller;

import com.example.airlinebackend.model.City;
import com.example.airlinebackend.service.CityService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public List<City> findAll() {
        return cityService.findAll();
    }

    @GetMapping("/city/{name}")
    public City findByName(@PathParam("name") String name){
        return cityService.findByName(name);
    }

    @PostMapping
    public City add(@RequestBody City city) {
        return cityService.addNewCity(city);
    }
}
