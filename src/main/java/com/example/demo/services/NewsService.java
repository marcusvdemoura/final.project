package com.example.demo.services;

import com.example.demo.domain.News;
import com.example.demo.repositories.NewsRepository;

import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NewsService {

    @Autowired
    private NewsRepository repo;

    public News find(UUID id){
        Optional<News> newsOptional = repo.findById(id);
        return newsOptional.orElseThrow(() -> new ObjectNotFoundException(("News not found! Id: " + id)));
    }

    public List<News> findAll(){

        return repo.findAll();

    }

    public News insert(News news){
        return repo.save(news);
    }

    public News update(News news){
        find(news.getId());
        return repo.save(news);
    }

    public void delete(UUID id){
        find(id);
        repo.deleteById(id);
    }

}
