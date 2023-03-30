package com.example.airlinebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightRoute {

    @Field
    private LocalDateTime arrival;

    @Field
    private LocalDateTime departure;

    @Field
    private City arrivalCity;

    @Field
    private City departureCity;
}
