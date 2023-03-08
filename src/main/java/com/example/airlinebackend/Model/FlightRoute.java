package com.example.airlinebackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightRoute {

    @Field
    private LocalDateTime arrival;

    @Field
    private LocalDateTime departure;

    @Field
    private String arrivalCity;

    @Field
    private String departureCity;
}
