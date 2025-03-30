package com.luv2code.springboot.demo.mycoolapp.rest;

import com.luv2code.springboot.demo.mycoolapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public FunRestController(
            @Qualifier("aquatic") Coach myCoach,
            @Qualifier("aquatic") Coach anotherCoach
    ) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

   @Value("${coach.name}")
    private String coachName;

   @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your luck day";
    }

    @GetMapping("/teaminfo")
    public String getTeaminfo() {
        return "Coach" + coachName + ", Team name :" + teamName;
    }

    @GetMapping("/check")
    public String check() {
        return "check compare beans : " + myCoach.equals(anotherCoach) ;
    }

}
