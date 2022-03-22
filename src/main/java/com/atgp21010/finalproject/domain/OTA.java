package com.atgp21010.finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OTA implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String website;
    @OneToMany(mappedBy = "ota")
    private List<Reservation> reservationList;

    public OTA(Integer id, String name, String website) {
        this.id = id;
        this.name = name;
        this.website = website;
    }
}
