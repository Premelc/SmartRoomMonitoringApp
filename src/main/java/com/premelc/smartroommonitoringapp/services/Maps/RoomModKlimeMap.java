package com.premelc.smartroommonitoringapp.services.Maps;

import com.premelc.smartroommonitoringapp.DTOs.AdriaIndoorDTOs.*;
import com.premelc.smartroommonitoringapp.models.*;

import java.util.*;

public class RoomModKlimeMap {

    public RoomModKlimeDto mapDto(List<AdriaIndoor> data){
        RoomModKlimeDto dto = new RoomModKlimeDto();
        dto.setParam("Mod klime");
        for (AdriaIndoor a : data){
            dto.setParam_time(a.getVrijeme() , a.getModKlime());
        }
        return dto;
    }
}
