package com.fundoo.notes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home() {
        return "Fundoo Notes Backend Running";
    }

    @GetMapping("/test")
    public String testApi() {
        return "SECURED API WORKING ✅";
    }
}