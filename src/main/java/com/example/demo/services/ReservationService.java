package com.example.demo.services;

import com.example.demo.domain.Reservation;
import com.example.demo.domain.domaindto.ReservationDTO;
import com.example.demo.repositories.ReservationRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private ReservationRepository repo;

    public Reservation find(UUID id){
        Optional<Reservation> reservation = repo.findById(id) ;

        return reservation.orElseThrow(() -> new ObjectNotFoundException(("Reservation not found! Id: " + id)));
    }

    public List<Reservation> findAll(){

        return repo.findAll();

    }

    public Reservation insert(Reservation reservation){

        return repo.save(reservation);
    }

    public Reservation update(Reservation reservation){
        find(reservation.getId());
        return repo.save(reservation);
    }

    public void delete(UUID id){
        find(id);
        try {
            repo.deleteById(id);
        } catch (ObjectNotFoundException e){
            throw new ObjectNotFoundException("No Reservation found with id: " + id);
        }
    }

    public Reservation fromDto(ReservationDTO reservationDTO){

        return new ModelMapper().map(reservationDTO, Reservation.class);

    }
}
