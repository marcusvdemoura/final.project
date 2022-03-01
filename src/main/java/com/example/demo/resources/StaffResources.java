package com.example.demo.resources;


import com.example.demo.domain.Staff;
import com.example.demo.domain.domaindto.StaffDTO;
import com.example.demo.services.StaffService;
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
@RequestMapping(value = "staff")
public class StaffResources {

    @Autowired
    private StaffService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Staff> find(@PathVariable UUID id){
        Staff staff = service.find(id);
        return ResponseEntity.ok().body(staff);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Staff>> findAll(){

        List<Staff> staff = service.findAll();

        return ResponseEntity.ok().body(staff);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody StaffDTO staffDto){

        Staff staff = new ModelMapper().map(staffDto, Staff.class);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(staff.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody StaffDTO staffDTO, @PathVariable UUID id){

        Staff staff = service.fromDto(staffDTO);
        staff.setId(id);
        staff = service.update(staff);
        return ResponseEntity.noContent().build();


    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Staff> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
