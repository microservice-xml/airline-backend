package com.example.airlinebackend.controller;

import com.example.airlinebackend.model.Flight;
import com.example.airlinebackend.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
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
    public List<Flight> searchFlights(@RequestParam("ticketPrice") int ticketPrice) {
        return flightService.searchFlights(ticketPrice);
    }
}