package com.example.demo.domain.enums;

public enum Positions {

    MANAGER (1, "Manager"),
    RECEPTIONIST(2, "Receptionist"),
    HOUSEKEEPING(3, "Housekeeping");

    Integer code;
    String position;

    Positions(Integer code, String position){
        this.code = code;
        this.position = position;
    }

    public Integer getCode() {
        return code;
    }

    public String getPosition() {
        return position;
    }

    public static Positions toEnum(Integer code){
        if (code == null){
            return null;
        }

        for (Positions x : Positions.values()){
            if(code.equals(x.getCode())){
                return x;
            }
        }

        throw new IllegalArgumentException("Wrong position input. Code: " + code);
    }


}
