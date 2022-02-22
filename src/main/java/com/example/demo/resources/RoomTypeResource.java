package com.example.demo.resources;

import com.example.demo.domain.RoomType;
import com.example.demo.domain.domaindto.RoomTypeDTO;
import com.example.demo.services.BedService;
import com.example.demo.services.RoomTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "rooms")
public class RoomTypeResource {

    @Autowired
    private RoomTypeService service;

    @Autowired
    private BedService bedService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<RoomType> find(@PathVariable Integer id){
        RoomType roomType = service.find(id);
        return ResponseEntity.ok().body(roomType);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<RoomType>> findAll(){

        List<RoomType> roomType = service.findAll();

        return ResponseEntity.ok().body(roomType);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody RoomTypeDTO roomTypeDTO){
        roomTypeDTO.setProperty(service.findPropertyById(roomTypeDTO.getPropertyId()));
        RoomType roomType = service.insert(new ModelMapper().map(roomTypeDTO, RoomType.class));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(roomType.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody RoomType roomType, @PathVariable Integer id){

        roomType.setId(id);

        return ResponseEntity.noContent().build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<RoomType> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
