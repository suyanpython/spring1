package com.luv2code.springboot.demo.mycoolapp.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.luv2code.springboot.demo.mycoolapp.entity.Employee;
import com.luv2code.springboot.demo.mycoolapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //private EmployeeDAO employeeDAO;
    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee theEmployee = employeeService.findById(id);
        if (theEmployee == null){
            throw new RuntimeException("Employee id not found - " + id);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee PatchEmployee(@PathVariable int employeeId,
                                  @RequestBody Map<String,Object> patchPlayload){
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        if (patchPlayload.containsKey("id")){
            throw new RuntimeException("Employee id not allowed in request body -" + employeeId);
        }

        Employee patchedEmployee = apply(patchPlayload, theEmployee);
        return employeeService.save(patchedEmployee);

    }

    private Employee apply(Map<String,Object> patchPlayload, Employee theEmployee){
        ObjectNode employeeNode = objectMapper.convertValue(theEmployee, ObjectNode.class);
        ObjectNode patchNode = objectMapper.convertValue(patchPlayload, ObjectNode.class);
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }

}
