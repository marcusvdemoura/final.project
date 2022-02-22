package com.example.demo.resources;


import com.example.demo.domain.Property;
import com.example.demo.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "properties")
public class PropertyResource {

    @Autowired
    private PropertyService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Property> find(@PathVariable Integer id){
        Property property = service.find(id);
        return ResponseEntity.ok().body(property);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Property>> findAll(){

        List<Property> property = service.findAll();

        return ResponseEntity.ok().body(property);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Property property){
        property = service.insert(property);
        property.addPropertyToList(property);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(property.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Property property, @PathVariable Integer id){

        property.setId(id);
        property = service.update(property);
        return ResponseEntity.noContent().build();


    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Property> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
