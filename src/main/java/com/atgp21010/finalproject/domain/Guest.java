package com.atgp21010.finalproject.domain;

import com.atgp21010.finalproject.domain.enums.ReservationStatus;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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
    @Column(unique = true)
    @NotNull
    private String email;
    @NotNull
    private String name;
    private String password;

//    create a logic to get the next reservation. We'll have to swap the elements in the reservation list bellow, so the res with the next check-in date is in index 0
//    private String nextReservation;



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



//    public void setBed() {
//        this.bed = defineBed();
//    }
//
//    public Bed getBed() {
//        defineBed();
//        return bed;
//    }

//    private Bed defineBed() {
//        Reservation res = getReservationList().get(0);
//        Room room = res.getRoom();
//        Bed bed = new Bed();
//        boolean param = false;
//        for (Bed b : room.getBeds()) {
//            if (b.getIsVacant()) {
//                b.setIsVacant(false);
//                bed = b;
//                param = true;
//                break;
//            }
//        }
//        return bed;
//
//
//    }

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
