package com.example.airlinebackend.dto;

import com.example.airlinebackend.model.Flight;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
public class TicketDto {

    private String id;

    private Flight flight;

    private double payedPrice;
}
