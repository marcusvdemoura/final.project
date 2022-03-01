package com.example.demo.domain.domaindto;


import com.example.demo.domain.Beds;
import com.example.demo.domain.Guest;
import com.example.demo.domain.RoomType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

public class GuestDTO {
    private static final long serialVersionUID = 1L;

    private UUID id;

    @NotEmpty(message ="Mandatory to fill in")
    private String name;
    @NotEmpty(message ="Mandatory to fill in")
    private String email;

    @NotEmpty(message ="Mandatory to fill in")
    @Length(min=5, max=20, message ="Size should be between 5 and 20")
    private String password;
    private int guestStatus;


    private RoomType roomType;
    private Beds beds;


   // private Reservation reservation;

//will we need beds and reservation in the dto ??
    //need to verify and test

    public GuestDTO(Guest g) {
        id = g.getId();
        name = g.getName();
        email = g.getEmail();
        password = g.getPassword();
        guestStatus = g.getGuestStatus().getCode();
        roomType = g.getRoomType();
        beds = g.getBed();

    }

    public GuestDTO() {

    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGuestStatus() {
        return guestStatus;
    }

    public void setGuestStatus(int guestStatus) {
        this.guestStatus = guestStatus;
    }

    public Beds getBeds() {
        return beds;
    }

    public void setBeds(Beds beds) {
        this.beds = beds;
    }
}
