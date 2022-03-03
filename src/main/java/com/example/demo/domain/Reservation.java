package com.example.demo.domain;

import com.example.demo.domain.enums.GuestStatus;
import com.example.demo.domain.enums.ReservationStatus;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

//needs annotations

public class Reservation {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid4")
    private UUID id;

    private String originalBookingNumber;
    private int ota;
    private int numberOfGuests;
    private int reservationStatus;
    private Property property;
    private ArrayList<RoomType> rommList;
    private ArrayList<Guest> guestList;
    private LocalDateTime checkin;
    private LocalDateTime checkout;

    public Reservation(UUID id,
                       String originalBookingNumber,
                       int ota, int numberOfGuests,
                       int reservationStatus,
                       Property property,
                       ArrayList<RoomType> rommList,
                       ArrayList<Guest> guestList,
                       LocalDateTime checkin,
                       LocalDateTime checkout) {
        this.id = id;
        this.originalBookingNumber = originalBookingNumber;
        this.ota = ota;
        this.numberOfGuests = numberOfGuests;
        this.reservationStatus = reservationStatus;
        this.property = property;
        this.rommList = rommList;
        this.guestList = guestList;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getOriginalBookingNumber() {
        return originalBookingNumber;
    }

    public void setOriginalBookingNumber(String originalBookingNumber) {
        this.originalBookingNumber = originalBookingNumber;
    }

    public int getOta() {
        return ota;
    }

    public void setOta(int ota) {
        this.ota = ota;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public ReservationStatus getReservationStatus() {
        return ReservationStatus.toEnum(this.reservationStatus);
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus.getCode();
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public ArrayList<RoomType> getRommList() {
        return rommList;
    }

    public void setRommList(ArrayList<RoomType> rommList) {
        this.rommList = rommList;
    }

    public ArrayList<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(ArrayList<Guest> guestList) {
        this.guestList = guestList;
    }

    public LocalDateTime getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDateTime checkin) {
        this.checkin = checkin;
    }

    public LocalDateTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDateTime checkout) {
        this.checkout = checkout;
    }
}
