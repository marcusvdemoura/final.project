package com.example.demo.services;

import com.example.demo.domain.Guest;
import com.example.demo.domain.domaindto.GuestDTO;
import com.example.demo.repositories.GuestRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GuestService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private GuestRepository repo;

    public Guest find(UUID id){
        Optional<Guest> guest = repo.findById(id);

        return guest.orElseThrow(() -> new ObjectNotFoundException(("Guest not found! Id: " + id)));
    }

    public List<Guest> findAll(){

        return repo.findAll();

    }

    public Guest insert(Guest guest){

        return repo.save(guest);
    }

    public Guest update(Guest guest){
        find(guest.getId());
        return repo.save(guest);
    }

    public void delete(UUID id){
        find(id);
        try {
            repo.deleteById(id);
        } catch (ObjectNotFoundException e){
            throw new ObjectNotFoundException("No Guest found with id: " + id);
        }
    }

    public Guest fromDto(GuestDTO guestDTO){

        return new ModelMapper().map(guestDTO, Guest.class);

    }
}
