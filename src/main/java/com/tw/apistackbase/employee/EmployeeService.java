package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDataService employeeDataService;

    @Autowired
    public EmployeeService(EmployeeDataService employeeDataService) {
        this.employeeDataService = employeeDataService;
    }

    public List<Employee> searchAll() {
        return new ArrayList<>(this.employeeDataService.getMockEmployee());
    }
}
