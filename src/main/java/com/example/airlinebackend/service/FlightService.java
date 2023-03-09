package com.example.airlinebackend.service;

import com.example.airlinebackend.exception.NotFoundException;
import com.example.airlinebackend.model.Flight;
import com.example.airlinebackend.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public Flight add(Flight flight){
        return flightRepository.save(flight);
    }

    public List<Flight> findAll(){
        return flightRepository.findAll();
    }
    public Flight findById(String id){
        return flightRepository.findById(id).orElseThrow(() -> new NotFoundException("Flight doesn't exist"));
    }

    public List<Flight> searchFlights(int ticketPrice) {
        List<Flight> flights = flightRepository.searchFlights(ticketPrice);
        return flights;
    }
}