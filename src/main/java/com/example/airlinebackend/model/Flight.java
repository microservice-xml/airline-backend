package com.example.airlinebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
@Builder
public class Flight {

    @Id
    private String id;

    @Field
    private String description;

    @Field
    private int numberOfSeats;

    @Field
    private int availableSeats;

    @Field
    private double ticketPrice;

    @Field
    private FlightRoute route;
}
