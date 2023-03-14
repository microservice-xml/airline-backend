package com.example.airlinebackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "news")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section {

    @Field
    private String title;

    @Field
    private String description;
}
