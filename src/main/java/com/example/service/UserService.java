package com.example.service;

import com.example.model.SelfAssessment;
import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    Map<Integer,User> userMap = new HashMap<>();
    Map<Integer, SelfAssessment> userAssessMap = new HashMap<>();
    static int i =0;

    public User registerUser(User user){
        if(user.getName()==null) {
            throw new RuntimeException("Invalid requset");
        }
        i++;
        User usr = new User();
        usr.setUserId(i);
        usr.setName(user.getName());
        usr.setPhoneNumber(user.getPhoneNumber());
        usr.setPinCode(user.getPinCode());
        usr.setResult(user.getResult());
        userMap.put(i,usr);
        User response = userMap.get(usr.getUserId());
        return response;
    }

    public int updateSymptom(int userid,SelfAssessment assessment){
        userAssessMap.put(userid,assessment);
        int risk=0;
        if(assessment.getSymptoms().size()==0 && !assessment.isTravelHistory() && !assessment.isContactWithCovidPt()){
            risk=5;
        }
        else if(assessment.getSymptoms().size()==1 && (assessment.isTravelHistory() || assessment.isContactWithCovidPt())){
            risk=50;
        }
        else if(assessment.getSymptoms().size()==2 && (assessment.isTravelHistory() || assessment.isContactWithCovidPt())){
            risk=75;
        }
        else if(assessment.getSymptoms().size()>2 && (assessment.isTravelHistory() || assessment.isContactWithCovidPt())){
            risk=95;
        }
        return risk;
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }
}
