package com.example.demo.domain;


import com.example.demo.domain.enums.Positions;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    private String username;

    @JsonIgnore
    private String password;
    private String name;
    private Integer position;

    public Staff(Integer id, String username, String password, String name, Positions position) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.position = position==null?null:position.getCode();
    }

    public Staff() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
