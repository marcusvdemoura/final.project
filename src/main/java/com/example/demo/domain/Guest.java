package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid4")
//    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;
    private String name;
    private String email;
    private String password;
    private int guestStatus;
    //private Reservation reservation;

   @OneToOne
    private Beds beds;

    public Guest() {

    }

    public Guest(UUID id, String name, String email, String password, int guestStatus, Beds beds) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.guestStatus = guestStatus;
        this.beds = beds;
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
        return beds;
    }

    public void setBed(Beds beds) {
        this.beds = beds;
    }
}
