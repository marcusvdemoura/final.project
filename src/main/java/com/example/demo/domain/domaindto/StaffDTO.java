package com.example.demo.domain.domaindto;


import com.example.demo.domain.Staff;
import com.example.demo.domain.enums.Positions;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.UUID;

public class StaffDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;

    @NotEmpty(message ="Mandatory to fill in")
    @Length(min=5, max=20, message ="Size should be between 5 and 20")
    private String username;

    @NotEmpty(message ="Mandatory to fill in")
    @Length(min=5, max=20, message ="Size should be between 5 and 20")
    private String password;
    private String name;
    private Integer position;

    public StaffDTO(Staff s) {
        id = s.getId();
        username = s.getUsername();
        password = s.getPassword();
        name = s.getName();
        position = s.getPosition().getCode();
    }

    public StaffDTO() {
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
