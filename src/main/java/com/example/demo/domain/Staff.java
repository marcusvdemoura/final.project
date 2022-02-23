package com.example.demo.domain;


import com.example.demo.domain.enums.Positions;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.type.UUIDCharType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid4")
//    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;



    private String username;

    @JsonIgnore
    private String password;
    private String name;
    private Integer position;

    public Staff(UUID id, String username, String password, String name, Positions position) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.position = position==null?null:position.getCode();
    }

    public Staff() {
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

    public Positions getPosition() {
        return Positions.toEnum(position);
    }

    public void setPosition(Positions position) {
        this.position = position.getCode();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
