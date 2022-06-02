package com.premelc.smartroommonitoringapp.services.Maps;

import com.premelc.smartroommonitoringapp.DTOs.DHMZObradenoDTOs.*;
import com.premelc.smartroommonitoringapp.models.*;

import java.util.*;

public class DHMZObradeniMap {

    public DHMZObradenoDto mapDto(List<DHMZObradeno> data , String param){
        DHMZObradenoDto dto = new DHMZObradenoDto();
        for (DHMZObradeno a : data) {
            if (param == "Zračenje") {
                dto.setTime(a.getVrijeme());
                dto.setParam(a.getZracenje());
            } else if (param == "Temperatura") {
                dto.setTime(a.getVrijeme());
                dto.setParam(a.getTemperatura());
            } else if (param == "Smjer vjetra") {
                dto.setTime(a.getVrijeme());
                dto.setParam(a.getSmjerVjetra());
            } else if (param == "Brzina vjetra") {
                dto.setTime(a.getVrijeme());
                dto.setParam(a.getBrzinaVjetra());
            } else if (param == "Vlažnost") {
                dto.setTime(a.getVrijeme());
                dto.setParam(a.getRelativnaVlaznost());
            }
        }
        return dto;
    }
}
