package com.example.tp2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tp2.service.CalculatorService;



@RestController
@RequestMapping("/")

public class OperationsController extends Exception{

private final CalculatorService<Double> opr;

public OperationsController(CalculatorService<Double> opr) {
    this.opr = opr;
}



    @GetMapping("/add")
    public Double add(@RequestParam Double a,@RequestParam Double b) {
        return opr.add(a, b);
    }

    @GetMapping("/div")
    public Double div(@RequestParam Double a,@RequestParam Double b) {
        return opr.div(a, b);
    }

    @GetMapping("/sub")
    public Double sub(@RequestParam Double a,@RequestParam Double b) {
        return opr.sub(a, b);
    }

    @GetMapping("/multi")
    public Double multi(@RequestParam Double a,@RequestParam Double b) {
        return opr.multi(a, b);
    }
}
