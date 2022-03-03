package com.example.demo.services;

import com.example.demo.domain.Guest;
import com.example.demo.domain.Staff;
import com.example.demo.repositories.GuestRepository;
import com.example.demo.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomGuestDetailsService implements UserDetailsService {

    @Autowired
    private GuestRepository guestRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Guest guest = guestRepository.findByEmail(email);
        return new User(guest.getEmail(), guest.getPassword(), new ArrayList<>());
    }
}