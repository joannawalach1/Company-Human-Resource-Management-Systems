package pl.great.waw.company3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.great.waw.company3.controller.EmployeeDto;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.domain.EmployeeData;
import pl.great.waw.company3.repository.EmployeeDataRepository;
import pl.great.waw.company3.repository.EmployeeRepository;
import pl.great.waw.company3.service.mapstruct.EmployeeMapperInterface;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeDataRepository employeeDataRepository;

    @Mock
    private EmployeeMapperInterface employeeMapperInterface;

    @Mock
    private Comparator comparator;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        List<Employee> employees = new ArrayList<>();
    }
    private Employee employee = new Employee("1234567890", "Anna", "Waren", BigDecimal.valueOf(4500));;
    private List<Employee> employees = List.of(employee);
    private EmployeeDto employeeDto= new EmployeeDto("1234567890", "Anna", "Waren", BigDecimal.valueOf(4500));


    @Test
    public void shouldCreateEmployee() {
        // Given
        when(employeeMapperInterface.dtoToEmployee(employeeDto)).thenReturn(employee);
        when(employeeRepository.create(employee)).thenReturn(employee);
        when(employeeMapperInterface.employeeToDto(employee)).thenReturn(employeeDto);

        // When
        EmployeeDto createdEmployeeDto = employeeService.create(employeeDto);

        // Then
        assertNotNull(createdEmployeeDto);
    }

    @Test
    public void shouldGetEmployee() {
        // Given
        String pesel = "1234567890";
        when(employeeRepository.get(pesel)).thenReturn(employee);
        when(employeeMapperInterface.employeeToDto(employee)).thenReturn(employeeDto);

        // When
        EmployeeDto retrievedEmployeeDto = employeeService.get(pesel);

        // Then
        assertNotNull(retrievedEmployeeDto);
    }

    @Test
    public void shouldDeleteEmployee() {
        // Given
        String pesel = "1234567890";
        when(employeeRepository.delete(pesel)).thenReturn(true);

        // When
        boolean isDeleted = employeeService.delete(pesel);

        // Then
        assertTrue(isDeleted);
    }

    @Test
    public void shouldUpdateEmployee() {
        // Given
        when(employeeMapperInterface.dtoToEmployee(employeeDto)).thenReturn(employee);
        when(employeeRepository.update(employee)).thenReturn(employee);
        when(employeeMapperInterface.employeeToDto(employee)).thenReturn(employeeDto);

        // When
        EmployeeDto updatedEmployeeDto = employeeService.update(employeeDto);

        // Then
        assertNotNull(updatedEmployeeDto);
    }

    @Test
    public void shouldGetAllEmployees() {
        // Given
        when(employeeMapperInterface.dtoToEmployee(employeeDto)).thenReturn(employee);
        when(employeeRepository.getAllEmployees()).thenReturn(employees);
        when(employeeMapperInterface.employeeToDto(employee)).thenReturn(employeeDto);

        // When

        List<EmployeeDto> allEmployeeDtos = employeeService.getAll();

        // Then

        assertNotNull(allEmployeeDtos);
    }

    @Test
    public void shouldSortEmployees() {
        // Given
        when(employeeRepository.sortAllEmployees(any(Comparator.class))).thenReturn(employees);
        when(employeeMapperInterface.employeeToDto(employee)).thenReturn(employeeDto);

        // When
        List<EmployeeDto> sortedEmployeeDtos = employeeService.sort(comparator);

        // Then
        assertNotNull(sortedEmployeeDtos);
    }

    @Test
    void shouldTotalYearlySalaryReturnOneThousandFiveHundred() {
        List<EmployeeData> employeesData = new ArrayList<>();
        EmployeeData employeeData1 = new EmployeeData("1", "1234567890", 4, 2023, BigDecimal.valueOf(1000), LocalDateTime.now(), LocalDateTime.now());
        EmployeeData employeeData2 = new EmployeeData("2", "1234567890", 5, 2023, BigDecimal.valueOf(500), LocalDateTime.now(), LocalDateTime.now());
        Collections.addAll(employeesData, employeeData1, employeeData2);
        when(employeeDataRepository.getYearlyData(any(), any(Integer.class))).thenReturn(employeesData);
        BigDecimal sum = employeeService.totalYearlySalary(employeeData1.getEmployeePesel(), employeeData1.getYear());
        assertEquals(BigDecimal.valueOf(1500), sum);
    }

    @Test
    void shouldTotalYearlySalaryReturnZero() {
        List<EmployeeData> employeesData = new ArrayList<>();
        when(employeeDataRepository.getYearlyData(any(), any(Integer.class))).thenReturn(employeesData);
        BigDecimal sum = employeeService.totalYearlySalary("4", 2022);
        assertEquals(BigDecimal.valueOf(0), sum);
    }

    @Test
    void shouldMonthlySalaryInYearReturnOneThousandFiveHundred() {
        List<EmployeeData> employeesData = new ArrayList<>();
        EmployeeData employeeData1 = new EmployeeData("1", "1234567890", 4, 2023, BigDecimal.valueOf(1000), LocalDateTime.now(), LocalDateTime.now());
        EmployeeData employeeData2 = new EmployeeData("2", "1234567890", 4, 2023, BigDecimal.valueOf(500), LocalDateTime.now(), LocalDateTime.now());
        Collections.addAll(employeesData, employeeData1, employeeData2);
        when(employeeDataRepository.getMonthlyData(any(), any(Integer.class), any(Integer.class))).thenReturn(employeesData);
        BigDecimal sum = employeeService.monthlySalaryInYear(employeeData1.getEmployeePesel(), employeeData1.getYear(), employeeData2.getMonth());
        assertEquals(BigDecimal.valueOf(1500), sum);
    }

    @Test
    void shouldMonthlySalaryInYearReturnZero() {
        List<EmployeeData> employeesData = new ArrayList<>();
        when(employeeDataRepository.getMonthlyData(any(), any(Integer.class), any(Integer.class))).thenReturn(employeesData);
        BigDecimal sum = employeeService.monthlySalaryInYear("4", 2022, 4);
        assertEquals(BigDecimal.valueOf(0), sum);
    }

    @Test
    void shouldTotalSalaryForEmpReturnOneThousandFiveHundred() {
        List<EmployeeData> employeesData = new ArrayList<>();
        EmployeeData employeeData1 = new EmployeeData("1", "1234567890", 4, 2023, BigDecimal.valueOf(1000), LocalDateTime.now(), LocalDateTime.now());
        EmployeeData employeeData2 = new EmployeeData("2", "1234567890", 4, 2023, BigDecimal.valueOf(500), LocalDateTime.now(), LocalDateTime.now());
        Collections.addAll(employeesData, employeeData1, employeeData2);
        when(employeeDataRepository.getTotalSalaryForEmp(any())).thenReturn(employeesData);
        BigDecimal sum = employeeService.totalSalaryForEmp(employeeData1.getEmployeePesel());
        assertEquals(BigDecimal.valueOf(1500), sum);
    }

    @Test
    void shouldTotalSalaryForEmpReturnZero() {
        List<EmployeeData> employeesData = new ArrayList<>();
        when(employeeDataRepository.getMonthlyData(any(), any(Integer.class), any(Integer.class))).thenReturn(employeesData);
        BigDecimal sum = employeeService.totalSalaryForEmp("4");
        assertEquals(BigDecimal.valueOf(0), sum);
    }
}
