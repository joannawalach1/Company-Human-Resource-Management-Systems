package pl.great.waw.company3.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pl.great.waw.company3.domain.Employee;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
class EmployeeRepositoryTest {

    private static final String TEST_PESEL = "23456";
    private static final String TEST_FIRSTNAME = "Steve";
    private static final String TEST_LASTNAME = "Brown";

    private final EmployeeRepository employeeRepo = new EmployeeRepository();

    @Test
    void getEmployee() {
        Employee employee = this.employeeRepo.createEmployee(new Employee(TEST_PESEL, TEST_FIRSTNAME, TEST_LASTNAME, BigDecimal.ONE));
        Employee emp = employeeRepo.getEmployee("23456");
        assertEquals(employee, emp);
    }
    @Test
    void createEmployee() {
        Employee employee = this.employeeRepo.createEmployee(new Employee(TEST_PESEL, TEST_FIRSTNAME, TEST_LASTNAME, BigDecimal.ONE));
        assertNotNull(employee);
        assertEquals(TEST_PESEL, employee.getPesel());
        assertEquals(TEST_FIRSTNAME, employee.getFirstName());
        assertEquals(TEST_LASTNAME, employee.getLastName());
        assertEquals(BigDecimal.ONE, employee.getSalary());
    }
}