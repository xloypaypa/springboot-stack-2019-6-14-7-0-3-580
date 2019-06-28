package com.tw.apistackbase.service;

import com.tw.apistackbase.config.EmployeeStub;
import com.tw.apistackbase.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeStub employeeStub;

    @Autowired
    public EmployeeService(EmployeeStub employeeStub) {
        this.employeeStub = employeeStub;
    }

    public List<Employee> searchAll() {
        return new ArrayList<>(this.employeeStub.getMockEmployee());
    }
}
