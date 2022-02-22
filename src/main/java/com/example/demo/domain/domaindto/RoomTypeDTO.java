package com.example.demo.domain.domaindto;



import com.example.demo.domain.Beds;
import com.example.demo.domain.Property;

import java.util.ArrayList;
import java.util.List;

public class RoomTypeDTO {

    private Integer id;
    private String type;
    private String roomNumber;
    private String floor;
    private Integer numberBeds;
    private Integer propertyId;
    private Property property;
    private List<Beds> bedsList = new ArrayList<>();

    public RoomTypeDTO() {
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

    public Integer getProperty() {
        return propertyId;
    }

    public void setProperty(Integer property) {
        this.propertyId = property;
    }

    public List<Beds> getBedsList() {
        return bedsList;
    }

    public void setBedsList(List<Beds> bedsList) {
        this.bedsList = bedsList;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
