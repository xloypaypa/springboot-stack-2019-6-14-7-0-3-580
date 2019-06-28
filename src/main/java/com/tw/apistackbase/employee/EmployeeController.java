package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeDataService employeeDataService;

    @Autowired
    public EmployeeController(EmployeeDataService employeeDataService) {
        this.employeeDataService = employeeDataService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> searchAll() {
        return ResponseEntity.ok(this.employeeDataService.getAllEmployees());
    }
}
