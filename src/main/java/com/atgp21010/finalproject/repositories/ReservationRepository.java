package com.atgp21010.finalproject.repositories;


import com.atgp21010.finalproject.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "reservation", path = "reservation")
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByOriginalBookingNumber(@Param("originalBookingNumber") String originalBookingNumber);
}
