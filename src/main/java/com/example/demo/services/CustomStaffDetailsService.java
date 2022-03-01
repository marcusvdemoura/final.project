package com.example.demo.services;

import com.example.demo.domain.Staff;
import com.example.demo.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomStaffDetailsService implements UserDetailsService {

    @Autowired
    private StaffRepository staffRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = staffRepository.findByUsername(username);
        return new User(staff.getUsername(), staff.getPassword(), new ArrayList<>());
    }
}
