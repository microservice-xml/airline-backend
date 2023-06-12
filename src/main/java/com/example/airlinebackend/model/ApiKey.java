package com.example.airlinebackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
@Builder
public class ApiKey {

    @Id
    private String id;

    @Field
    private String key;

    @Field
    private LocalDateTime expiryDate;

    @Field
    private String userId;

    @Field
    private boolean permanent;
}
