package com.luv2code.springboot.demo.mycoolapp.common;

public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("In constructor:" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "do some swimming";
    }
}
