package com.example.service;

import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ZoneService {
    Map<Integer,String> zoneMap = new HashMap<>();
    @Autowired
    UserService userService;


    public String getZoneInfo(int pincode){
        int countInZone=0;
        Map temp = userService.getUserMap();
        for(Object entry : temp.values()){
            User user = (User)entry;
            if(user.getResult()=="positive" && user.getPinCode()==pincode){
                countInZone++;
            }
        }
        if(countInZone>0 && countInZone<5)
            return "ORANGE";
        else if (countInZone>=5)
            return "RED";
        else
            return "GREEN";
    }
}
