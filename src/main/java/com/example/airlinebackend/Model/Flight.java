package com.example.airlinebackend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Flight {

    @Id
    private String id;

    @Field
    private String description;

    @Field
    private int numberOfSeats;

    @Field
    private double ticketPrice;

    private FlightRoute route;
}
