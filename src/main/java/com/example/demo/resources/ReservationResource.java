package com.example.demo.resources;



import com.example.demo.domain.Reservation;
import com.example.demo.domain.domaindto.ReservationDTO;
import com.example.demo.services.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "reservation")
public class ReservationResource {

    @Autowired
    private ReservationService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Reservation> find(@PathVariable UUID id){
        Reservation reservation = service.find(id);
        return ResponseEntity.ok().body(reservation);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> findAll(){

        List<Reservation> reservation = service.findAll();

        return ResponseEntity.ok().body(reservation);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody ReservationDTO reservationDto){

        Reservation reservation = new ModelMapper().map(reservationDto, Reservation.class);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(reservation.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ReservationDTO reservationDTO, @PathVariable UUID id){

        Reservation reservation = service.fromDto(reservationDTO);
        reservation.setId(id);
        //  guest = service.update(guest);
        return ResponseEntity.noContent().build();


    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Reservation> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
