package com.example.airlinebackend.model;

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
public class City {

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String airport;

    @Field
    private String iata_code;

}
