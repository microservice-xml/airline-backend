package com.example.airlinebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
@Builder
public class Ticket {

    @Id
    private String id;

    @Field
    private String userId;

    @Field
    private String flightId;

    @Field
    private double payedPrice;
}
