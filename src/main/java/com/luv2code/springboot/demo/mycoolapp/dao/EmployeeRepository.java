package com.luv2code.springboot.demo.mycoolapp.dao;

import com.luv2code.springboot.demo.mycoolapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
