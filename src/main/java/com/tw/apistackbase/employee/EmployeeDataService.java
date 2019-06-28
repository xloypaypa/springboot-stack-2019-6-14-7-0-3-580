package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Employee;
import com.tw.apistackbase.employee.entity.Gender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDataService {

    private final Map<Integer, Employee> employees;

    public EmployeeDataService(List<Employee> employees) {
        this.employees = new HashMap<>();
        for (Employee employee : employees) {
            this.employees.put(employee.getId(), employee);
        }
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(this.employees.values());
    }

    public void addEmploy(Employee employee) {
        this.employees.put(employee.getId(), employee);
    }

    public void removeEmployee(int id) {
        this.employees.remove(id);
    }

    public Employee searchEmployee(int id) {
        return this.employees.get(id);
    }
}
