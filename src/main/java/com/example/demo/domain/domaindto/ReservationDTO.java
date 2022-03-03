package com.example.demo.domain.domaindto;

import com.example.demo.domain.Guest;
import com.example.demo.domain.Property;
import com.example.demo.domain.Reservation;
import com.example.demo.domain.RoomType;
import com.example.demo.domain.enums.ReservationStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

//needs annotation

public class ReservationDTO {

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

    public ReservationDTO(Reservation r){
        id = r.getId();
        originalBookingNumber = r.getOriginalBookingNumber();
        ota = r.getOta();
        numberOfGuests = r.getNumberOfGuests();
        reservationStatus = r.getReservationStatus().getCode();
        property = r.getProperty();
        rommList = r.getRommList();
        guestList = r.getGuestList();
        checkin = r.getCheckin();
        checkout = r.getCheckout();

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
