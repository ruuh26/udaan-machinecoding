package com.example.controller;

import com.example.model.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin){
        Admin response = this.adminService.registerAdmin(admin);
        return new ResponseEntity<Admin>(response,HttpStatus.OK);
    }

    @PostMapping("/{userId}/{adminId}/{result}")
    public String updateCovidResult(@PathVariable int userid, @PathVariable int adminId, @PathVariable String result){
        this.adminService.updateCovidResult(adminId,userid,result);
        return "Success";
    }
}
