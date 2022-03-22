package com.atgp21010.finalproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
    private String roomNumber;
    private String floor;
    private Integer numberBeds;
    private String rfidTag;

    public Room() {

    }

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bed_id")
    private List<Bed> beds;

    @ManyToMany(mappedBy = "roomList")
    private List<Reservation> reservationList = new ArrayList<>();



    public void setNumberBeds(Integer numberBeds){
        this.numberBeds=numberBeds;
        createBeds();
    }

    public void createBeds(){
        List<Bed> beds = new ArrayList<>();
        for(int i =1; i <= numberBeds; i++){

            Bed bed = new Bed();
            bed.setRoomNumber(this.getRoomNumber());
            bed.setIsVacant(true);
            bed.setNumber(i);
            beds.add(bed);
        }

        setBeds(beds);
    }


}
