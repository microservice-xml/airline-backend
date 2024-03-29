package com.example.airlinebackend.controller;

import com.example.airlinebackend.dto.FlightDto;
import com.example.airlinebackend.model.Flight;
import com.example.airlinebackend.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity add(@RequestBody FlightDto flight) {
        return ResponseEntity.ok(flightService.add(flight));
    }

    @GetMapping("/{id}")
    public Flight findById(@PathVariable("id") String id){
        return flightService.findById(id);
    }

    @GetMapping("/search")
    public List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDate departure, LocalDate arrival, int desiredSeats) {
        return flightService.searchFlights(departureCity, arrivalCity, departure, arrival, desiredSeats);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable("id") String id){
        flightService.delete(id);
    }
}
