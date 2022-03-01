package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Beds implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private String roomNumber;
    private boolean isClean;
    private boolean isRefresh;

    @OneToOne
    @JsonIgnoreProperties("beds")
    private Guest guest;



    public Beds(Integer id, Integer number, String roomNumber, boolean isClean, boolean isRefresh) {
        this.id = id;
        this.number = number;
        this.roomNumber = roomNumber;
        this.isClean = isClean;
        this.isRefresh = isRefresh;
        if(this.isRefresh == true)
            this.isClean = false;


    }

    public Beds() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public boolean isRefresh() {
        return isRefresh;
    }

    public void setRefresh(boolean refresh) {
        isRefresh = refresh;
    }

    public void setGuest(Guest guest){
        this.guest=guest;
    }

    public Guest getGuest() {
        return guest;
    }
}
