package com.example.controller;

import com.example.model.SelfAssessment;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        User response = this.userService.registerUser(user);
        return new ResponseEntity<User>(response,HttpStatus.OK);
    }

    @PostMapping("/assessment/")
    public int selfAssessment(@RequestBody SelfAssessment assessment){
        int userId = assessment.getUserId();
        return this.userService.updateSymptom(userId,assessment);
    }
}
