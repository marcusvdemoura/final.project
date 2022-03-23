package com.atgp21010.finalproject.repositories;


import com.atgp21010.finalproject.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "news", path = "news")
public interface NewsRepository extends JpaRepository<News, Integer> {

    List<News> findByMessage(@Param("message") String message);
}
