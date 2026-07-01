package com.billgrouppro.billing_software.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Hello {
    @GetMapping("/api/Hello")
    public String sayHello(){
        return "<h1>hello from billing software<h1/>";
    }
    @GetMapping("/api/Number")
    public int getNumber(){
        return 4;
    }
}
