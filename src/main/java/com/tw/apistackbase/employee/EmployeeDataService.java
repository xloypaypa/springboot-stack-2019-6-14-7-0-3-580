package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Employee;
import com.tw.apistackbase.employee.entity.Gender;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class EmployeeDataService {

    public List<Employee> getMockEmployee() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Xiaoming", 20, Gender.MALE));
        employees.add(new Employee(2, "Xiaohong", 19, Gender.FEMALE));
        employees.add(new Employee(3, "Xiaozhi", 15, Gender.MALE));
        return employees;
    }

}
