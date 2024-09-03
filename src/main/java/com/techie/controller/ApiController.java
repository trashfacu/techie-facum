package com.techie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ApiController {

    @GetMapping("/api")
    public String unreliableApi() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("API is down");
        }
        return "API response";
    }
}
