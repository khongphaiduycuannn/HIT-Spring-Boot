package com.example.demo;

import org.springframework.stereotype.Component;

@Component("Iphone")
public class Iphone implements Phone{
    @Override
    public void isUsing() {
        System.out.println("Student is using Iphone");
    }
}
