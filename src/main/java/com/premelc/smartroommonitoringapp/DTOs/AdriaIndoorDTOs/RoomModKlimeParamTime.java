package com.premelc.smartroommonitoringapp.DTOs.AdriaIndoorDTOs;

public class RoomModKlimeParamTime {

    private long time;
    private String param;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public RoomModKlimeParamTime(long time, String param) {
        this.time = time;
        this.param = param;
    }

    @Override
    public String toString() {
        return "RoomModKlimeParamTime{" +
                "time=" + time +
                ", param='" + param + '\'' +
                '}';
    }
}
