package com.atgp21010.finalproject.repositories;

import com.atgp21010.finalproject.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(path = "guest", collectionResourceRel = "guest")
public interface GuestRepository extends JpaRepository<Guest, Integer> {

    List<Guest> findByName(@Param("name") String name);

    Guest findByEmail(String email);
}
