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
    @Query(" {'route.departureCity' :?0 , 'route.arrivalCity' :?1 , 'route.departure' :?2 , 'route.arrival' :?3 , availableSeats : { '$gte': ?4 } }")
    List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDateTime arrival, LocalDateTime departure, int desiredSeats);
}
