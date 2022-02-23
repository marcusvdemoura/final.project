package com.example.demo.services;



import com.example.demo.domain.Staff;
import com.example.demo.domain.domaindto.StaffDTO;
import com.example.demo.repositories.StaffRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StaffService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private StaffRepository repo;

    public Staff find(UUID id){
        Optional<Staff> staff = repo.findById(id);

        return staff.orElseThrow(() -> new ObjectNotFoundException(("Staff not found! Id: " + id)));
    }

    public List<Staff> findAll(){

        return repo.findAll();

    }


    public Staff insert(Staff staff){

        return repo.save(staff);
    }

    public Staff update(Staff staff){
        find(staff.getId());
        return repo.save(staff);
    }

    public void delete(UUID id){
        find(id);
        try {
            repo.deleteById(id);
        } catch (ObjectNotFoundException e){
            throw new ObjectNotFoundException("No staff found with id: " + id);
        }
    }

    public Staff fromDto(StaffDTO staffDTO){

        return new ModelMapper().map(staffDTO, Staff.class);
//        return new Staff(staffDTO.getId(), staffDTO.getUsername(),pe.encode(staffDTO.getPassword()),
//                staffDTO.getName(), staffDTO.getPosition());
    }


}
