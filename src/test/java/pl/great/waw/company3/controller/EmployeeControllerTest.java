package pl.great.waw.company3.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.great.waw.company3.domain.EmployeeData;
import pl.great.waw.company3.repository.EmployeeDataRepository;
import pl.great.waw.company3.service.EmployeeService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {
    private List<EmployeeData> employeeDataList;
    @Mock
    EmployeeService employeeService;

    @Mock
    EmployeeDataRepository employeeDataRepository;

    @InjectMocks
    EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        List<EmployeeData> employeeDataList = new ArrayList<>();
        EmployeeData employee1 = new EmployeeData("1", "1234567890", 4, 2023, BigDecimal.valueOf(2000), LocalDateTime.now(), LocalDateTime.now());
        EmployeeData employee2 = new EmployeeData("2", "1234567890", 5, 2023, BigDecimal.valueOf(3000), LocalDateTime.now(), LocalDateTime.now());
        employeeDataList.add(employee1);
        employeeDataList.add(employee2);
    }

    @Test
    void getYearlySalary() {
        String pesel = "1234567890";
        int year = 2023;
        BigDecimal totalSalary = BigDecimal.valueOf(5000);
        when(employeeService.totalYearlySalary(pesel, year)).thenReturn(totalSalary);
        BigDecimal resultList = employeeController.getYearlySum(pesel, year);
        assertEquals(BigDecimal.valueOf(5000), resultList);
    }

    @Test
    void getMonthlySalary() {
        String pesel = "1234567890";
        int month = 5;
        int year = 2024;
        BigDecimal totalSalary = BigDecimal.valueOf(3000);
        when(employeeService.monthlySalaryInYear(pesel, year, month)).thenReturn(totalSalary);
        BigDecimal resultList = employeeController.getMonthSalary(pesel, year, month);
        assertEquals(totalSalary, resultList);
    }

    @Test
    void getTotalSalaryForEmployee() {
        String pesel = "1234567890";
        BigDecimal totalSalary = new BigDecimal("5000");
        when(employeeService.totalSalaryForEmp(pesel)).thenReturn(totalSalary);
        BigDecimal result = employeeController.getTotalSalary(pesel);
        assertEquals(totalSalary, result);
    }
}