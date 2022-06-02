package com.premelc.smartroommonitoringapp.DTOs.AdriaIndoorDTOs;

import java.util.*;

public class RoomModKlimeDto {
    private String room_num;
    private String param;
    private ArrayList<RoomModKlimeParamTime> param_time;

    public String getRoom_num() {
        return room_num;
    }

    public void setRoom_num(String room_num) {
        this.room_num = room_num;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public ArrayList<RoomModKlimeParamTime> getParam_time() {
        return param_time;
    }

    public void setParam_time(long time , String param) {
        this.param_time.add(new RoomModKlimeParamTime(time , param));
    }

    @Override
    public String toString() {
        String str = null;
        for(RoomModKlimeParamTime s : this.getParam_time()){
            str+= s.toString();
        }


        return "RoomModKlimeDto{" +
                "room_num='" + room_num + '\'' +
                ", param='" + param + '\'' +
                ", param_time= { " + '\'' + str + '}' +
                '}';
    }
}
