package com.atgp21010.finalproject.domain;

import com.atgp21010.finalproject.domain.enums.ReservationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String name;
    private String password;
    private String data = this.toString();

    @ManyToMany
    @JoinTable(
            name = "reservation_guest",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private List<Reservation> reservationList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "bed_id")
    private Bed bed;

    public void setBed() {
        this.bed = defineBed();
    }

    public Bed getBed() {
        defineBed();
        return bed;
    }

    private Bed defineBed(){
        Reservation res = getReservationList().get(0);
        List<Room> rooms = res.getRoomList();
        Bed bed = new Bed();
        for (Room r : rooms){
            boolean param = false;
            for (Bed b : r.getBeds()){
                if (b.getIsVacant()){
                    b.setIsVacant(false);
                    bed = b;
                    param = true;
                    break;
                }
            }
            if(param){
                break;
            }
        }
        return bed;

    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", reservationList=" + reservationList +
                ", bed=" + bed +
                '}';
    }
}
