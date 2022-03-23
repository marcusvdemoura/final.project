package com.atgp21010.finalproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bed implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roomNumber;

    private Integer number;

    private Boolean isVacant;

    @OneToOne(mappedBy = "bed")
    private Guest guest;


}
