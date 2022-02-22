package com.example.demo.services;

import com.example.demo.domain.ImportantVariables;
import com.example.demo.domain.Property;
import com.example.demo.domain.RoomType;
import com.example.demo.repositories.RoomTypeRepository;
import com.example.demo.services.exceptions.DataIntegrityException;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeService {


    @Autowired
    private RoomTypeRepository repo;


    public RoomType find(Integer id){
        Optional<RoomType> roomType = repo.findById(id);
        return roomType.orElseThrow(() -> new ObjectNotFoundException(("Room type not found! Id: " + id)));
    }

    public List<RoomType> findAll(){

        return repo.findAll();

    }

    public RoomType insert(RoomType roomType){
        roomType.createBeds();
        return repo.save(roomType);
    }

    public RoomType update(RoomType roomType){
        find(roomType.getId());
        return repo.save(roomType);
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("It's not possible to delete rooms with beds assigned to it");
        }
    }

    public Property findPropertyById(Integer propertyId){
        for (Property p : ImportantVariables.PROPERTY_LIST){
            if (p.getId() == propertyId)
                return p;
        }
        return null;
    }


}
