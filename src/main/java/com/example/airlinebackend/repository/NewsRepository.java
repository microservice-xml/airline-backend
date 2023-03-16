package com.example.airlinebackend.repository;

import com.example.airlinebackend.model.News;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends MongoRepository<News, String> {

    @Aggregation(pipeline = {"{ $sample: { size: 1 }}"})
    News getRandomArticle();
}
