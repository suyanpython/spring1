package com.luv2code.springboot.demo.mycoolapp.service;

import com.luv2code.springboot.demo.mycoolapp.dao.EmployeeDAO;
import com.luv2code.springboot.demo.mycoolapp.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpolyeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    public EmpolyeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public Employee update(Employee theEmployee) {
        return employeeDAO.update(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
