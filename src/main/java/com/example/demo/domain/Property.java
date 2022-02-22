package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Property implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;

    @JsonIgnoreProperties(value = {"rooms", "property", "bedsList"})
    @OneToMany(mappedBy = "property")
    private List<RoomType> rooms = new ArrayList<>();

    public Property() {
    }

    public Property(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<RoomType> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<RoomType> rooms) {
        this.rooms = rooms;
    }

    public void addPropertyToList(Property p){
        ImportantVariables.PROPERTY_LIST.add(p);
    }
}
