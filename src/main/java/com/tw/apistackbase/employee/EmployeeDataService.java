package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Employee;
import com.tw.apistackbase.employee.entity.Gender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDataService {

    public final List<Employee> employees;

    public EmployeeDataService() {
        this.employees = new ArrayList<>();
        employees.add(new Employee(1, "Xiaoming", 20, Gender.MALE));
        employees.add(new Employee(2, "Xiaohong", 19, Gender.FEMALE));
        employees.add(new Employee(3, "Xiaozhi", 15, Gender.MALE));
    }

    public List<Employee> getMockEmployee() {
        return new ArrayList<>(this.employees);
    }

}
