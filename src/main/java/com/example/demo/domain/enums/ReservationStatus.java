package com.example.demo.domain.enums;

public enum ReservationStatus {

    CONFIRMED(1,"Confirmed"),
    INHOUSE(2, "In-house"),
    CHECKEDOUT(3, "Checked-out"),
    CANCELLED(4, "Cancelled");


    Integer code;
    String desc;

    ReservationStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ReservationStatus toEnum(Integer code){
        if (code == null){
            return null;
        }

        for (ReservationStatus x : ReservationStatus.values()){
            if(code.equals(x.getCode())){
                return x;
            }
        }

        throw new IllegalArgumentException("Wrong reservation status input. Code: " + code);
    }
}
