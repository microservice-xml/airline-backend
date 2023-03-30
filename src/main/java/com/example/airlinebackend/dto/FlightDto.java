package com.example.airlinebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {

    private LocalDateTime arrival;

    private String arrivalCity;

    private LocalDateTime departure;

    private String departureCity;

    private String desc;

    private int numSeats;

    private double price;
}
