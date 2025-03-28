package com.luv2code.springboot.demo.mycoolapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
   // @value("${coach.name}")
    //private Sting coachName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/workout")
    public String getWorkout() {
        return "Run a hard 5k";
    }

}
