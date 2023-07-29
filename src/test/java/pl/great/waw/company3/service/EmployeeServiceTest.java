package pl.great.waw.company3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.great.waw.company3.controller.EmployeeDto;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.EmployeeDataRepository;
import pl.great.waw.company3.repository.EmployeeRepository;
import pl.great.waw.company3.service.mapper.EmployeeMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeDataRepository employeeDataRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @Mock
    private Comparator comparator;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateEmployee() {
        // Given
        EmployeeDto employeeDto = new EmployeeDto("1234567890", "Anna", "Waren", BigDecimal.valueOf(4500));
        Employee employee = new Employee("1234567890", "Anna", "Waren", BigDecimal.valueOf(4500));
        when(employeeMapper.fromDto(employeeDto)).thenReturn(employee);
        when(employeeRepository.create(employee)).thenReturn(employee);
        when(employeeMapper.toDto(employee)).thenReturn(employeeDto);

        // When
        EmployeeDto createdEmployeeDto = employeeService.create(employeeDto);

        // Then
        assertNotNull(createdEmployeeDto);
    }

    @Test
    public void testGetEmployee() {
        // Given
        String pesel = "0123456789";
        EmployeeDto employeeDto = new EmployeeDto("1234567890", "Anna", "Waren", BigDecimal.valueOf(4500));
        Employee employee = new Employee("0123456789", "Anna", "Waren", BigDecimal.valueOf(4500));
        when(employeeRepository.get(pesel)).thenReturn(employee);
        when(employeeMapper.toDto(employee)).thenReturn(employeeDto);

        // When
        EmployeeDto retrievedEmployeeDto = employeeService.get(pesel);

        // Then
        assertNotNull(retrievedEmployeeDto);
    }

    @Test
    public void testDeleteEmployee() {
        // Given
        String pesel = "0123456789";
        when(employeeRepository.delete(pesel)).thenReturn(true);

        // When
        boolean isDeleted = employeeService.delete(pesel);

        // Then
        assertTrue(isDeleted);
    }

    @Test
    public void testUpdateEmployee() {
        // Given
        EmployeeDto employeeDto = new EmployeeDto("0123456789", "Anna", "Waren", BigDecimal.valueOf(4500));
        Employee employee = new Employee("0123456789", "Anna", "Waren", BigDecimal.valueOf(4500));
        when(employeeMapper.fromDto(employeeDto)).thenReturn(employee);
        when(employeeRepository.update(employee)).thenReturn(employee);
        when(employeeMapper.toDto(employee)).thenReturn(employeeDto);

        // When
        EmployeeDto updatedEmployeeDto = employeeService.update(employeeDto);

        // Then
        assertNotNull(updatedEmployeeDto);
    }

    @Test
    public void testGetAllEmployees() {
        // Given
        List<Employee> employees = new ArrayList<>();
        EmployeeDto employeeDto = new EmployeeDto("1234567890", "Anna", "Waren", BigDecimal.valueOf(4500));
        Employee employee1 = new Employee("0123456789", "Anna", "Waren", BigDecimal.valueOf(4500));
        Employee employee2 = new Employee("0123456790", "Anna", "Waren", BigDecimal.valueOf(4500));
        employees.add(employee1);
        employees.add(employee2);
        when(employeeRepository.getAllEmployees()).thenReturn(employees);
        when(employeeMapper.toDto(employee1)).thenReturn(employeeDto);
        when(employeeMapper.toDto(employee2)).thenReturn(employeeDto);

        // When
        List<EmployeeDto> allEmployeeDtos = employeeService.getAll();

        // Then
        assertNotNull(allEmployeeDtos);
    }

    @Test
    public void testSortEmployees() {
        // Given
        List<Employee> employees = new ArrayList<>();
        EmployeeDto employeeDto = new EmployeeDto("1234567890", "Anna", "Waren", BigDecimal.valueOf(4500));
        Employee employee1 = new Employee("0123456789", "Anna", "Waren", BigDecimal.valueOf(4500));
        Employee employee2 = new Employee("0123456790", "Anna", "Waren", BigDecimal.valueOf(4500));
        employees.add(employee1);
        employees.add(employee2);
        when(employeeRepository.sortAllEmployees(any(Comparator.class))).thenReturn(employees);
        when(employeeMapper.toDto(employee1)).thenReturn(employeeDto);

        // When
        List<EmployeeDto> sortedEmployeeDtos = employeeService.sort(comparator);

        // Then
        assertNotNull(sortedEmployeeDtos);
    }
}
