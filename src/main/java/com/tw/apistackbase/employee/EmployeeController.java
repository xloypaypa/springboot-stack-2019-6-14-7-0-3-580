package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> searchAll() {
        return ResponseEntity.ok(this.employeeService.getAllEmployees());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> searchById(@PathVariable int id) {
        return ResponseEntity.ok(this.employeeService.searchEmployee(id));
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable int id) {
        this.employeeService.removeEmployee(id);
        return ResponseEntity.ok("");
    }
}
