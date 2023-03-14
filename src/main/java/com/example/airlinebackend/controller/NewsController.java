package com.example.airlinebackend.controller;

import com.example.airlinebackend.model.News;
import com.example.airlinebackend.model.User;
import com.example.airlinebackend.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
@CrossOrigin
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public List<News> findAll() {
        return newsService.findAll();
    }

    @PostMapping
    public News add(@RequestBody News news) {
        return newsService.add(news);
    }

    @GetMapping("/{id}")
    public News findById(@PathVariable("id") String id){
        return newsService.findById(id);
    }
}
