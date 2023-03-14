package com.example.airlinebackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class News {

    @Id
    private String id;

    @Field
    private String title;

    @Field
    private String author;

    @Field
    private String slug;

    @Field
    private LocalDateTime createdOn;

    @Field
    private String subHeader;

    @Field
    private String description;

    private List<Section> sections;
}
