package com.example.demo.domain.enums;

public enum GuestStatus {

    CONFIRMED(1,"Confirmed"),
    INHOUSE(2, "In-house"),
    CHECKEDOUT(3, "Checked-out"),
    CANCELLED(4, "Cancelled");


    Integer code;
    String desc;

    GuestStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static GuestStatus toEnum(Integer code){
        if (code == null){
            return null;
        }

        for (GuestStatus x : GuestStatus.values()){
            if(code.equals(x.getCode())){
                return x;
            }
        }

        throw new IllegalArgumentException("Wrong position input. Code: " + code);
    }
}
