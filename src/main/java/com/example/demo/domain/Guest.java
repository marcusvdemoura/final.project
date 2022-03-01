package com.example.demo.domain;

import com.example.demo.domain.enums.GuestStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
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

    //guestService conferir
    //guestDTO conferir
    //criar guest Resources
    //Testar guest entity

    @ManyToOne
    @JoinColumn (name = "room_id")
    @JsonIgnoreProperties({"bedsList", "guestList"})
    private RoomType roomType;

   @OneToOne
   private Beds beds;

    public Guest() {

    }

    public Guest(UUID id, String name, String email, String password, int guestStatus, RoomType roomType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.guestStatus = guestStatus;
        this.roomType = roomType;
        roomType.getGuestList().add(this);

        for(Beds b: this.roomType.getBedsList()){
            if (b.getGuest()==null){
                b.setGuest(this);
                this.beds = b;
                break;
            }
        }
    }

    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
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

    public GuestStatus getGuestStatus() {
        return GuestStatus.toEnum(this.guestStatus);
    }

    public void setGuestStatus(GuestStatus guestStatus) {
        this.guestStatus = guestStatus.getCode();
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Beds getBed() {
        return beds;
    }

    public void setBed(Beds beds) {
        this.beds = beds;
    }
}
