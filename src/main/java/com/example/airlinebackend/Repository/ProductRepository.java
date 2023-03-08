package com.example.airlinebackend.Repository;

import com.example.airlinebackend.SetupDB.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
