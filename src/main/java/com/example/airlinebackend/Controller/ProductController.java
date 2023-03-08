package com.example.airlinebackend.Controller;

import com.example.airlinebackend.Repository.ProductRepository;
import com.example.airlinebackend.SetupDB.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @PostMapping
    Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
