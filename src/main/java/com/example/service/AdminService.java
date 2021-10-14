package com.example.service;

import com.example.model.Admin;
import com.example.model.SelfAssessment;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {
    @Autowired
    UserService userService;
    Map<Integer, Admin> adminMap = new HashMap<Integer, Admin>();
    Map<Integer, SelfAssessment> userAssessMap = new HashMap<>();
    static int j =0;
    public Admin registerAdmin(Admin admin){
        if(admin.getName()==null) {
            throw new RuntimeException("Invalid requset");
        }
        j++;
        Admin adm = new Admin();
        adm.setAdminId(j);
        adm.setName(admin.getName());
        adm.setPhoneNumber(admin.getPhoneNumber());
        adm.setPinCode(admin.getPinCode());
        adminMap.put(j,adm);
        Admin response  = adminMap.get(adm.getAdminId());
        return response;
    }

    public void updateCovidResult(int adminId, int userId, String result){
        User user = userService.userMap.get(userId);
        user.setResult(result);
        userService.userMap.put(userId,user);
    }
}
