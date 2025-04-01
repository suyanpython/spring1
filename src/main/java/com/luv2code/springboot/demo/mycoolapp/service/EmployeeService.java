package com.luv2code.springboot.demo.mycoolapp.service;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);

    Employee save(Employee theEmployee);

    Employee update(Employee theEmployee);

    void  deleteById(int theId);
}
