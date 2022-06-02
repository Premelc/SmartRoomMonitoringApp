package com.premelc.smartroommonitoringapp.DTOs.AdriaIndoorDTOs;

public class AdriaIndoorParamTime {
    private long time;
    private int param;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }

    public AdriaIndoorParamTime(long time, int param) {
        this.time = time;
        this.param = param;
    }

    @Override
    public String toString() {
        return "AdriaIndoorParamTime{" +
                "time=" + time +
                ", param=" + param +
                '}';
    }
}
