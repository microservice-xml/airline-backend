package com.example.airlinebackend.repository;

import com.example.airlinebackend.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String>  {
    @Query(" {'route.arrival' :?0 , 'route.arrivalCity' :?1 , 'route.departureCity' :?2 , availableSeats : { '$gte': ?3 } }")
    List<Flight> searchFlights(LocalDateTime arrival, String arrivalCity, String departureCity, int desiredSeats);
}
