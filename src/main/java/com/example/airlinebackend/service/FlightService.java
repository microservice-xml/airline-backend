package com.example.airlinebackend.service;

import com.example.airlinebackend.exception.NotFoundException;
import com.example.airlinebackend.model.Flight;
import com.example.airlinebackend.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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

    public List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDate arrival, LocalDate departure, int desiredSeats) {
        LocalDate dayAfterDeparture;
        LocalDate dayAfterArrival;

        dayAfterDeparture = departure.plusDays(1);
        dayAfterArrival = arrival.plusDays(1);

        try {
            List<Flight> flights = flightRepository.searchFlights(departureCity, arrivalCity, departure, dayAfterDeparture, arrival, dayAfterArrival, desiredSeats);
            return flights;
        } catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

    public void purchaseTickets(Flight flight, Integer purchasedTicketsCount) {
        flight.setAvailableSeats(flight.getAvailableSeats() - purchasedTicketsCount);
        flightRepository.save(flight);
    }
}
