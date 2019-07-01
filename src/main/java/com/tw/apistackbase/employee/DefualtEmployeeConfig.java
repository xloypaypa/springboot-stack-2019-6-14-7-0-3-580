package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Company;
import com.tw.apistackbase.employee.entity.Employee;
import com.tw.apistackbase.employee.entity.Gender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
class DefaultEmployeeConfig {

    @Bean
    public EmployeeService employeeDataService() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Xiaoming", 20, Gender.MALE));
        employees.add(new Employee(2, "Xiaohong", 19, Gender.FEMALE));
        employees.add(new Employee(3, "Xiaozhi", 15, Gender.MALE));
        return new EmployeeService(employees);
    }

    @Bean
    public CompanyService companyDataService(EmployeeService employeeService) {
        List<Company> companies = Arrays.asList(
                new Company(1, "alibaba", Arrays.asList(employeeService.searchEmployee(1), employeeService.searchEmployee(3))),
                new Company(2, "bilibli", Collections.singletonList(employeeService.searchEmployee(2))));
        return new CompanyService(companies);
    }

}
