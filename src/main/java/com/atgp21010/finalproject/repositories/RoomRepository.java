package com.atgp21010.finalproject.repositories;

import com.atgp21010.finalproject.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "room", path = "room")
public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findByType(@Param("type") String type);
}
