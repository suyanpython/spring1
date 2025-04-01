package com.luv2code.springboot.demo.mycoolapp.rest;

import com.luv2code.springboot.demo.mycoolapp.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;
    private Integer id;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Student1", "A", "e@e.com"));
        theStudents.add(new Student("Student2", "B", "e@e.com"));
        theStudents.add(new Student("Student3", "C", "e@e.com"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Integer id) {
        this.id = id;

        if(id >= theStudents.size() || id < 0){
            throw new StudentNotFoundException("Student id not found - " + id);
        }
       return theStudents.get(id);
    }
}
