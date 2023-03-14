package com.example.airlinebackend.service;

import com.example.airlinebackend.exception.NotFoundException;
import com.example.airlinebackend.model.News;
import com.example.airlinebackend.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public News add(News news) {
        return newsRepository.save(news);
    }

    public News findById(String id){
        return newsRepository.findById(id).orElseThrow(() -> new NotFoundException("News doesn't exist"));
    }

    public List<News> findAll() {
        return newsRepository.findAll();
    }

}
