package com.example.airlinebackend.repository;

import com.example.airlinebackend.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String>  {
    @Query(" {ticketPrice :?0}")
    List<Flight> searchFlights(int ticketPrice);
}
