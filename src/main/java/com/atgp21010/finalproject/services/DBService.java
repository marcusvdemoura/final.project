package com.atgp21010.finalproject.services;


import com.atgp21010.finalproject.domain.*;
import com.atgp21010.finalproject.domain.enums.ReservationStatus;
import com.atgp21010.finalproject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder pe;


    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BedRepository bedRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private OTARepository otaRepository;

    @Autowired
    private GuestRepository guestRepository;



    public void instantiateTestDatabase() {

        Property gardinerHouse = new Property();
        gardinerHouse.setName("Gardiner House");
        gardinerHouse.setAddress("Gardiner Street");

        Room sixteenBed = new Room();
        sixteenBed.setType("Sixteen bed shared");

        sixteenBed.setFloor("First");
        sixteenBed.setProperty(gardinerHouse);
        sixteenBed.setRoomNumber("6A");
        sixteenBed.setNumberBeds(16);



        News firstNews = new News();
        firstNews.setMessage("This is the first news");
        firstNews.setImageURL("https://images.squarespace-cdn.com/content/v1/5b0c1e198f51300662cc2786/1621607320555-HWNLI39F2LCRYUN3R920/CHOLESTEROL-logo.png?format=1000w");

        OTA bookingcom = new OTA(null, "Booking.com", "www.booking.com");

        Reservation firstReservation = new Reservation();
        firstReservation.setOriginalBookingNumber("A123456");
        firstReservation.setNumberOfGuests(2);
        firstReservation.setProperty(gardinerHouse);
        firstReservation.getRoomList().add(sixteenBed);
        firstReservation.setOta(bookingcom);
        firstReservation.setCheckin(LocalDate.of(2022,05,20));
        firstReservation.setCheckout(LocalDate.of(2022,06,20));
        firstReservation.setReservationStatus(ReservationStatus.CONFIRMED);





        Guest firstGuest = new Guest();
        Guest secondGuest = new Guest();

        firstGuest.setName("Marcus");
        firstGuest.setUsername("marcus@moura.com");
        firstGuest.setPassword(pe.encode("123456"));
        firstGuest.getReservationList().add(firstReservation);

        secondGuest.setName("Janis Celm");
        secondGuest.setUsername("janis@celmars.com");
        secondGuest.setPassword(pe.encode("123456"));
        secondGuest.getReservationList().add(firstReservation);



        propertyRepository.save(gardinerHouse);
        roomRepository.save(sixteenBed);
        bedRepository.saveAll(sixteenBed.getBeds());
        newsRepository.save(firstNews);
        otaRepository.save(bookingcom);
        reservationRepository.save(firstReservation);
        guestRepository.saveAll(Arrays.asList(firstGuest, secondGuest));






    }
}
