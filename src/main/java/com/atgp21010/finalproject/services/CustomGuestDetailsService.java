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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Guest guest = guestRepository.findByUsername(username);
        return new User(guest.getUsername(), guest.getPassword(), new ArrayList<>());
    }
}
