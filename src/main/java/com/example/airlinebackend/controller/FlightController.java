package com.example.airlinebackend.controller;

import com.example.airlinebackend.model.Flight;
import com.example.airlinebackend.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/flight")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public List<Flight> findAll() {
        return flightService.findAll();
    }

    @PostMapping
    public Flight add(@RequestBody Flight flight) {
        return flightService.add(flight);
    }

    @GetMapping("/{id}")
    public Flight findById(@PathVariable("id") String id){
        return flightService.findById(id);
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDateTime arrival, LocalDateTime departure, int desiredSeats) {
        return flightService.searchFlights(departureCity, arrivalCity, departure, arrival, desiredSeats);
    }
}
