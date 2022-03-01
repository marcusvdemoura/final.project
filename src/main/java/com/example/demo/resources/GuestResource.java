package com.example.demo.resources;

import com.example.demo.domain.Guest;
import com.example.demo.domain.domaindto.GuestDTO;
import com.example.demo.services.GuestService;
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
@RequestMapping(value = "guest")
public class GuestResource {

    @Autowired
    private GuestService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Guest> find(@PathVariable UUID id){
        Guest guest = service.find(id);
        return ResponseEntity.ok().body(guest);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Guest>> findAll(){

        List<Guest> guest = service.findAll();

        return ResponseEntity.ok().body(guest);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody GuestDTO guestDto){

        Guest guest = new ModelMapper().map(guestDto, Guest.class);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(guest.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody GuestDTO guestDTO, @PathVariable UUID id){

        Guest guest = service.fromDto(guestDTO);
        guest.setId(id);
      //  guest = service.update(guest);
        return ResponseEntity.noContent().build();


    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Guest> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
