package com.atgp21010.finalproject.services;


import com.atgp21010.finalproject.domain.Guest;
import com.atgp21010.finalproject.repositories.GuestRepository;
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
