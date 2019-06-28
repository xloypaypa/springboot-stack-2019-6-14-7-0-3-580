package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Employee;
import com.tw.apistackbase.employee.entity.Gender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDataService {

    private final List<Employee> employees;

    public EmployeeDataService(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(this.employees);
    }

    public void addEmploy(Employee employee) {
        this.employees.add(employee);
    }
}
