package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.UUID;

public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid4")
//    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;

 // @JsonIgnore
    private String name;
    private String email;
    private String password;
    private int guestStatus;
    //private Reservation reservation;


   @OneToOne
    private Beds bed; //could it be an array

    public Guest() {

    }

    public Guest(UUID id, String name, String email, String password, int guestStatus, Beds bed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.guestStatus = guestStatus;
        this.bed = bed;
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

    public Beds getBed() {
        return bed;
    }

    public void setBed(Beds bed) {
        this.bed = bed;
    }
}
