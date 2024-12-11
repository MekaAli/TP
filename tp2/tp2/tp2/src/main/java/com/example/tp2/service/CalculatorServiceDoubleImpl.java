package com.example.tp2.service;

import org.springframework.stereotype.Service;


@Service
public class CalculatorServiceDoubleImpl implements CalculatorService <Double> {
    
    public Double a;
    public Double B;

    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double multi(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double sub(Double a, Double b) {
        return a-b;
    }

    @Override
    public Double div(Double a, Double b) {
        if(b == 0){throw new ArithmeticException("Cannot divide on 0");}
        return a/b;
    }
    
}
