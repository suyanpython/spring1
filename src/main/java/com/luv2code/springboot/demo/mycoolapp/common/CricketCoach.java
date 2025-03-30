package com.luv2code.springboot.demo.mycoolapp.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor:" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "do some cricket";
    }
}
