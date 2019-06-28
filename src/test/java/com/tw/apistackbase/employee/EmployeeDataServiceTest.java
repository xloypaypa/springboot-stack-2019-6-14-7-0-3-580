package com.tw.apistackbase.employee;

import com.tw.apistackbase.employee.entity.Employee;
import com.tw.apistackbase.employee.entity.Gender;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDataServiceTest {

    @Test
    public void should_return_default_employee_list_when_get_employee_list() {
        List<Employee> except = new ArrayList<>();
        except.add(new Employee(1, "Xiaoming", 20, Gender.MALE));
        except.add(new Employee(2, "Xiaohong", 19, Gender.FEMALE));
        except.add(new Employee(3, "Xiaozhi", 15, Gender.MALE));
        EmployeeDataService employeeDataService = new EmployeeDataService(except);

        List<Employee> actual = employeeDataService.getAllEmployees();

        assertEquals(except, actual);
    }
}