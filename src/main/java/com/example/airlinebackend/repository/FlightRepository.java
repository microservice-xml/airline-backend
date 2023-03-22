package com.example.airlinebackend.repository;

import com.example.airlinebackend.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String>  {
    @Query(" {'route.departureCity.name' :?0 , 'route.arrivalCity.name' :?1 , 'route.departure' :{ '$gte' : ?2, '$lte' :  ?3} , 'route.arrival' :{ '$gte' : ?4, '$lte' :  ?5} , availableSeats : { '$gte': ?6 } }")
    List<Flight> searchFlights(String departureCity, String arrivalCity, LocalDate departure, LocalDate dayAfterDeparture, LocalDate arrival, LocalDate dayAfterArrival, int desiredSeats);
}
