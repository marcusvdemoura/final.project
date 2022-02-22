package com.example.demo.services;


import com.example.demo.domain.Property;
import com.example.demo.repositories.PropertyRepository;
import com.example.demo.services.exceptions.DataIntegrityException;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository repo;

    public Property find(Integer id){
        Optional<Property> propertyOptional = repo.findById(id);
        return propertyOptional.orElseThrow(() -> new ObjectNotFoundException(("Property not found! Id: " + id)));
    }

    public List<Property> findAll(){

        return repo.findAll();

    }

    public Property insert(Property property){
        return repo.save(property);
    }

    public Property update(Property property){
        find(property.getId());
        return repo.save(property);
    }

    public void delete(Integer id){
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("It's not possible to delete properties with rooms assigned to it");
        }
    }

}
