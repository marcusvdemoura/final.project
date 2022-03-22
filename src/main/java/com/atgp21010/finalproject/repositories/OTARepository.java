package com.atgp21010.finalproject.repositories;

import com.atgp21010.finalproject.domain.OTA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "ota", path = "ota")
public interface OTARepository extends JpaRepository<OTA, Integer> {

    List<OTA> findByName(@Param("name") String name);
}
