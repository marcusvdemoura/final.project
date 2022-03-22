package com.atgp21010.finalproject.repositories;


import com.atgp21010.finalproject.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "properties", path = "properties")
public interface PropertyRepository extends JpaRepository<Property, Integer> {

    List<Property> findByName(@Param("name") String name);
}
