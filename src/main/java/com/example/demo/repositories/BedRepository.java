package com.example.demo.repositories;

import com.example.demo.domain.Beds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedRepository extends JpaRepository<Beds, Integer> {
}
