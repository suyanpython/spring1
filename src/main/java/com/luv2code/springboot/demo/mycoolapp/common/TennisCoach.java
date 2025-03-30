package com.luv2code.springboot.demo.mycoolapp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary

@Component
public class TennisCoach implements Coach {
    @PostConstruct
    public void init() {
        System.out.println("In init method:" + getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("In destroy method:" + getClass().getSimpleName());
    }

    public TennisCoach() {
        System.out.println("In constructor:" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "do some tennis";
    }
}
