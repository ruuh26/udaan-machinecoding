package com.example.controller;

import com.example.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zone")
@CrossOrigin("*")
public class ZoneController {
    @Autowired
    ZoneService zoneService;

    @GetMapping("/{pinCode}")
    public String getZoneInfo(@PathVariable("pinCode") int pinCode){
        return zoneService.getZoneInfo(pinCode);
    }
}
