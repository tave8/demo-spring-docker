package com.giuseppetavella.com.demo_spring_docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Home {
    
    @GetMapping
    public String home() {
        return "hello from Demo Spring Docker app";
    }
}
