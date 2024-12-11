package com.example.tp2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AddController {
    


    @GetMapping("/addd")
    public Double addDoubles(@RequestParam("a") Double a,@RequestParam("b") Double b) {
        return a+b ;
    }
    
    
}
