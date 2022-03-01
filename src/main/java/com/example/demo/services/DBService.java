package com.example.demo.services;


import com.example.demo.domain.*;

import com.example.demo.domain.enums.Positions;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DBService {


    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private GuestRepository guestRepository;

    public DBService() {
    }

    public void instantiateTestDatabase() {

        List<Staff> listStaff = Stream.of(
                new Staff(null, "marcus@moura", pe.encode("12345"),
               "Marcus Moura", Positions.RECEPTIONIST),
                        new Staff(null, "carol@propato", pe.encode("12345"),
               "Carol Propato", Positions.MANAGER),
                new Staff(null, "maya@santos", pe.encode("12345"),
                "Maya Santos", Positions.MANAGER)
        ).collect(Collectors.toList());

        // THESE ARE THE OBJECTS CREATED BEFORE BUT WITHOUT THE PASSWORD ENCODING TO MAKE IT EASIER FOR TESTING

//        List<Staff> listStaff = Stream.of(
//                new Staff(null, "marcus@moura", "12345",
//                        "Marcus Moura", Positions.RECEPTIONIST),
//                new Staff(null, "carol@propato", "12345",
//                        "Carol Propato", Positions.MANAGER),
//                new Staff(null, "maya@santos", "12345",
//                        "Maya Santos", Positions.MANAGER)
//        ).collect(Collectors.toList());

        staffRepository.saveAll(listStaff);

        // ============================

        Property gardinerHouse = new Property(null, "Gardiner House",
                "76, Gardiner Upper Street");
        gardinerHouse.addPropertyToList(gardinerHouse);
        RoomType sixteenBedChapel = new RoomType(null, "18-bed dorm mixed",
                "6A", "Chapel", 16, gardinerHouse);

        RoomType eightBedMixed = new RoomType(null, "8-bed dorm mixed", "10", "1", 8, gardinerHouse);

        propertyRepository.save(gardinerHouse);
        roomTypeRepository.saveAll(Arrays.asList(sixteenBedChapel, eightBedMixed));
        bedRepository.saveAll(sixteenBedChapel.getBedsList());
        bedRepository.saveAll(eightBedMixed.getBedsList());
        String imageMessage = "This is a test image";
        String imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.istockphoto.com%2Fphotos%2Fgalway&psig=AOvVaw1Y4TJPKf76_47nl1iiYfjV&ust=1645801669435000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCJiD15DPmPYCFQAAAAAdAAAAABAD";
        News news1 = new News(null, imageUrl, imageMessage);
        newsRepository.save(news1);


        List<Guest> guestList = Stream.of(
                new Guest(
                        null, "Jose", "jose@gmail.com", pe.encode("1234"), 1, sixteenBedChapel),
                new Guest(
                        null, "Marcus", "marcus@moura.com", pe.encode("1234"), 1, sixteenBedChapel)
                ).collect(Collectors.toList());


        guestRepository.saveAll(guestList);
        roomTypeRepository.saveAll(Arrays.asList(sixteenBedChapel, eightBedMixed));


        // update beds with the new data -> which guest is in there.
        // update roomtype bedlist with the guest in each bed

    }


}
