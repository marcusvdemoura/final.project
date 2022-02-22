package com.example.demo.resources;

import com.example.demo.domain.Beds;
import com.example.demo.domain.domaindto.BedsDTO;
import com.example.demo.services.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "beds")
public class BedResource {

    @Autowired
    private BedService service;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Beds> find(@PathVariable Integer id){
        Beds bed = service.find(id);
        return ResponseEntity.ok().body(bed);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<BedsDTO>> findAll(){

        List<Beds> bed = service.findAll();
        List<BedsDTO> bedsDTOS = bed.stream().map(BedsDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(bedsDTOS);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Beds beds){
        beds = service.insert(beds);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(beds.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Beds bed, @PathVariable Integer id){

        bed.setId(id);
        bed = service.update(bed);
        return ResponseEntity.noContent().build();


    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Beds> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<BedsDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "24") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "room") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ){

        Page<Beds> beds = service.findPage(page, linesPerPage, orderBy, direction);

        Page<BedsDTO> bedsDTOS = beds.map(BedsDTO::new);

        return ResponseEntity.ok().body(bedsDTOS);

    }


}
