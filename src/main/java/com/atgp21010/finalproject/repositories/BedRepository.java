package com.atgp21010.finalproject.repositories;

import com.atgp21010.finalproject.domain.Bed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "bed", path = "bed")
public interface BedRepository extends JpaRepository<Bed, Integer> {

    List<Bed> findByIsVacant(@Param("isVacant") Boolean isVacant);
}
