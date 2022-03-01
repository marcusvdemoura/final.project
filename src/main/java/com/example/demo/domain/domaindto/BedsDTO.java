package com.example.demo.domain.domaindto;



import com.example.demo.domain.Beds;

import java.io.Serializable;

public class BedsDTO implements Serializable {
    private static final long serialVersionUID = 1L;



    private Integer id;
    private Integer number;
    private String roomNumber;
    private boolean isClean;
    private boolean isRefresh;

    public BedsDTO(Integer id, Integer number, String roomNumber, boolean isClean, boolean isRefresh) {
        this.id = id;
        this.number = number;
        this.roomNumber = roomNumber;
        this.isClean = isClean;
        this.isRefresh = isRefresh;
    }

    public BedsDTO(){}

    public BedsDTO(Beds beds){

        this.id = beds.getId();
        this.number = beds.getNumber();
        this.isClean = beds.isClean();
        this.isRefresh = beds.isRefresh();
        this.roomNumber = beds.getRoomNumber();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public boolean isRefresh() {
        return isRefresh;
    }

    public void setRefresh(boolean refresh) {
        isRefresh = refresh;
    }
}
