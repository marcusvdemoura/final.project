package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RoomType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
    private String roomNumber;
    private String floor;
    private Integer numberBeds;

    @ManyToOne
    @JoinColumn(name = "property_id")
    @JsonIgnoreProperties(value = "rooms")
    private Property property;


    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "room")
    private List<Beds> bedsList = new ArrayList<>();

    @OneToMany(mappedBy = "roomType")
    private List<Guest> guestList = new ArrayList<>();



    public RoomType() {
    }

    public RoomType(Integer id, String type, String roomNumber, String floor, Integer numberBeds, Property property) {
        this.id = id;
        this.type = type;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.property = property;
        this.numberBeds = numberBeds;
        this.property.getRooms().add(this);

        createBeds();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getNumberBeds() {
        return numberBeds;
    }

    public void setNumberBeds(Integer numberBeds) {
        this.numberBeds = numberBeds;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public List<Beds> getBedsList() {
        return bedsList;
    }

    public void createBeds(){

        for(int i = 1; i<=getNumberBeds(); i++){
            getBedsList().add(new Beds(null, i, getRoomNumber(), true, false));
        }


    }

    public List<Guest> getGuestList() {
        return guestList;
    }
}
