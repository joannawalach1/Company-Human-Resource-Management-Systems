package pl.great.waw.company3.repository;

import org.junit.jupiter.api.Test;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.sorter.Sorter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {
    private static final String TEST_PESEL = "23456";
    private static final String TEST_FIRSTNAME = "Steve";
    protected static final String TEST_LASTNAME = "Brown";

    private static final String TEST_FIRSTNAME_2 = "Leon";
    private static final String TEST_LASTNAME_2 = "Zawodowiec";

    private final EmployeeRepository employeeRepo = new EmployeeRepository();


    @Test
    void getEmployee() {
        Employee employee = this.employeeRepo.createEmployee(new Employee("23456", "Steve", "Brown", BigDecimal.ONE));
        Employee emp = employeeRepo.getEmployee("23456");
        assertEquals(employee, emp);
    }

    @Test
    void createEmployee() {
        Employee employee = this.employeeRepo.createEmployee(new Employee("23456", "Steve", "Brown", BigDecimal.ONE));
        assertTrue(employee != null);
        assertEquals(TEST_PESEL, employee.getPesel());
        assertEquals(TEST_FIRSTNAME, employee.getFirstName());
        assertEquals(TEST_LASTNAME, employee.getLastName());
        assertEquals(BigDecimal.ONE, employee.getSalary());
    }

    @Test
    void delete() {
        Employee employee = this.employeeRepo.createEmployee(new Employee(TEST_PESEL, TEST_FIRSTNAME, TEST_LASTNAME, BigDecimal.ONE));
        assertTrue(employeeRepo.deleteEmployee(TEST_PESEL));
    }

    @Test
    void updateEmployee() {
        this.employeeRepo.createEmployee(new Employee(TEST_PESEL, TEST_FIRSTNAME, TEST_LASTNAME, BigDecimal.ONE));
        Employee employee2 = new Employee(TEST_PESEL, TEST_FIRSTNAME_2, TEST_LASTNAME_2, BigDecimal.ONE);

        Employee savedEmployee = this.employeeRepo.updateEmployee(employee2);

        assertEquals(savedEmployee, this.employeeRepo.getEmployee(employee2.getPesel()));
    }

    @Test
    void getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = this.employeeRepo.createEmployee(new Employee("111111", "Gart", "Well", BigDecimal.ONE));
        Employee employee2 = this.employeeRepo.createEmployee(new Employee("222222", "Rety", "Bell", BigDecimal.ONE));
        Employee employee3 = this.employeeRepo.createEmployee(new Employee("333333", "Sort", "Dell", BigDecimal.TEN));
        this.employeeRepo.getAllEmployees();
        assertNotNull(employees);
    }

    @Test
    void sortEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("111111", "Gart", "Well", BigDecimal.ONE);
        Employee employee2 = new Employee("222222", "Rety", "Bell", BigDecimal.ONE);
        Employee employee3 = new Employee("333333", "Sort", "Dell", BigDecimal.TEN);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        this.employeeRepo.createEmployee(employee1);
        this.employeeRepo.createEmployee(employee2);
        this.employeeRepo.createEmployee(employee3);
        List<Employee> sorted = this.employeeRepo.sortAllEmployees(new LastNameEmployeeComparator());
        assertNotNull(employees);

        assertEquals(employee2, sorted.get(0));
        assertEquals(employee1, sorted.get(2));
    }
}
