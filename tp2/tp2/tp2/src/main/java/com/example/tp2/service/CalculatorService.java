package com.example.tp2.service;

public interface CalculatorService<T extends Number> {
    T add(T a,T b);
    T multi(T a,T b);
    T sub(T a,T b);
    T div(T a,T b);

}
