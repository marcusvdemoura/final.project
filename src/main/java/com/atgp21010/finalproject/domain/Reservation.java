package com.atgp21010.finalproject.domain;


import com.atgp21010.finalproject.domain.enums.ReservationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ota_id")
    private OTA ota;
    private String originalBookingNumber;
    private Integer reservationStatus;
    private Integer numberOfGuests;
    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @ManyToOne(fetch = FetchType.EAGER)
    private Room room;


    @ManyToMany(mappedBy = "reservationList")
    private List<Guest> guestList = new ArrayList<>();

    private LocalDate checkin;
    private LocalDate checkout;


    public ReservationStatus getReservationStatus() {
        return ReservationStatus.toEnum(this.reservationStatus);
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus.getCode();
    }
}
