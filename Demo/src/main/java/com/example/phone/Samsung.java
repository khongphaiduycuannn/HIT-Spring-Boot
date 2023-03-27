package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Samsung implements Phone{
    @Override
    public void isUsing() {
        System.out.println("Student is using Samsung");
    }
}
