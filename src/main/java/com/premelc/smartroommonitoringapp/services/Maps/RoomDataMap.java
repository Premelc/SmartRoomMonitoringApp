package com.premelc.smartroommonitoringapp.services.Maps;

import com.premelc.smartroommonitoringapp.DTOs.AdriaIndoorDTOs.*;
import com.premelc.smartroommonitoringapp.models.*;

import java.util.*;

public class RoomDataMap {

    public RoomDataDto mapDto(List<AdriaIndoor> data , String param){
        RoomDataDto dto = new RoomDataDto();
        dto.setParam(param);
        for (AdriaIndoor a : data){
            if(param == "Zadana"){
                dto.setParam_time(a.getVrijeme() , a.getZadana());
            }else if(param == "Izmjerena"){
                dto.setParam_time(a.getVrijeme() , a.getIzmjerena());
            }else if(param == "Status klime"){
                dto.setParam_time(a.getVrijeme() , a.getStatusKlime());
            }else if(param == "Brzina puhanja"){
                dto.setParam_time(a.getVrijeme() , a.getBrzinaPuhanja());
            }else if(param == "Ventil"){
                dto.setParam_time(a.getVrijeme() , a.getVentil());
            }else if(param == "Prisutnost"){
                dto.setParam_time(a.getVrijeme() , a.getPrisutnost());
            }else if(param == "Prozor"){
                dto.setParam_time(a.getVrijeme() , a.getProzor());
            }else if(param == "WC set"){
                dto.setParam_time(a.getVrijeme() , a.getWc_set());
            }else if(param == "WC mjerenja"){
                dto.setParam_time(a.getVrijeme() , a.getWcMjerenja());
            }
        }
        return dto;
    }
}
