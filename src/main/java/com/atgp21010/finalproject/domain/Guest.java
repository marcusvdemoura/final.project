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
    @GeneratedValue(generator = "uuid4")
    private UUID id;
    private String username;
    private String name;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "reservation_guest",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private List<Reservation> reservationList = new ArrayList<>();
}
