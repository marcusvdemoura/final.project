package com.example.demo.resources;


import com.example.demo.domain.News;
import com.example.demo.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "news")
public class NewsResource {


    @Autowired
    private NewsService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<News> find(@PathVariable Integer id){
        News news = service.find(id);
        return ResponseEntity.ok().body(news);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<News>> findAll(){

        List<News> news = service.findAll();

        return ResponseEntity.ok().body(news);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody News news){
        news = service.insert(news);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(news.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody News news, @PathVariable Integer id){

        news.setId(id);
        news = service.update(news);
        return ResponseEntity.noContent().build();


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<News> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
