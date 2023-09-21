package com.ordermanagement.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HealthController {

    @GetMapping("/health")
    public String health(){
        return "Order Management Application is up";
    }
}
