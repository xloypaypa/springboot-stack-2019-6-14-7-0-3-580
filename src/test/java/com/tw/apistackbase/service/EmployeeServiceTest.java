package com.tw.apistackbase.service;

import com.tw.apistackbase.config.EmployeeStub;
import com.tw.apistackbase.entity.Employee;
import com.tw.apistackbase.entity.Gender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private EmployeeStub employeeStub;

    @Before
    public void setUp() throws Exception {
        this.employeeStub = mock(EmployeeStub.class);
        this.employeeService = new EmployeeService(this.employeeStub);
    }

    @Test
    public void should_call_mocked_employee_stub_when_search_all_employee_list() {
        this.employeeService.searchAll();

        verify(this.employeeStub).getMockEmployee();
    }

    @Test
    public void should_return_employee_when_search_all_employee_list() {
        List<Employee> except = Collections.singletonList(new Employee(1, "name", 18, Gender.MALE));
        when(this.employeeStub.getMockEmployee()).thenReturn(except);

        List<Employee> actual = this.employeeService.searchAll();

        assertEquals(except, actual);
    }
}