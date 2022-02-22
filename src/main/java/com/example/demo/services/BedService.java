package com.example.demo.services;

import com.example.demo.domain.Beds;
import com.example.demo.repositories.BedRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BedService {

    @Autowired
    private BedRepository repo;

    public Beds find(Integer id){
        Optional<Beds> bed = repo.findById(id);
        return bed.orElseThrow(()->new ObjectNotFoundException("Bed not found"));
    }

    public List<Beds> findAll(){

        return repo.findAll();

    }

    public Beds insert(Beds beds){

        return repo.save(beds);

    }

    public Beds update(Beds beds){
        find(beds.getId());
        return repo.save(beds);
    }

    public void delete(Integer id){
        find(id);
        repo.deleteById(id);
    }

    public Page<Beds> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);

        return repo.findAll(pageRequest);

    }
}
