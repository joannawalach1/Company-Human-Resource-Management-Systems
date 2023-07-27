package pl.great.waw.company3.repository;

import org.junit.jupiter.api.Test;
import pl.great.waw.company3.domain.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeCrudRepositoryTest {

    private static final String TEST_PESEL = "23456";
    private static final String TEST_FIRSTNAME = "Steve";
    private static final String TEST_LASTNAME = "Brown";

    private static final String TEST_FIRSTNAME_2 = "Leon";
    private static final String TEST_LASTNAME_2 = "Zawodowiec";

    private final EmployeeRepository employeeRepo = new EmployeeRepository();


    @Test
    void getEmployee() {
        Employee employee = this.employeeRepo.create(new Employee("23456", "Steve", "Brown", BigDecimal.ONE));
        Employee emp = employeeRepo.get("23456");
        assertEquals(employee, emp);
    }

    @Test
    void createEmployee() {
        Employee employee = this.employeeRepo.create(new Employee("23456", "Steve", "Brown", BigDecimal.ONE));
        assertTrue(employee != null);
        assertEquals(TEST_PESEL, employee.getPesel());
        assertEquals(TEST_FIRSTNAME, employee.getFirstName());
        assertEquals(TEST_LASTNAME, employee.getLastName());
        assertEquals(BigDecimal.ONE, employee.getSalary());
    }

    @Test
    void delete() {
        Employee employee = this.employeeRepo.create(new Employee(TEST_PESEL, TEST_FIRSTNAME, TEST_LASTNAME, BigDecimal.ONE));
        assertTrue(employeeRepo.delete(TEST_PESEL));
    }

    @Test
    void updateEmployee() {
        this.employeeRepo.create(new Employee(TEST_PESEL, TEST_FIRSTNAME, TEST_LASTNAME, BigDecimal.ONE));
        Employee employee2 = new Employee(TEST_PESEL, TEST_FIRSTNAME_2, TEST_LASTNAME_2, BigDecimal.ONE);

        Employee savedEmployee = this.employeeRepo.update(employee2);

        assertEquals(savedEmployee, this.employeeRepo.get(employee2.getPesel()));
    }

    @Test
    void getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = this.employeeRepo.create(new Employee("111111", "Gart", "Well", BigDecimal.ONE));
        Employee employee2 = this.employeeRepo.create(new Employee("222222", "Rety", "Bell", BigDecimal.ONE));
        Employee employee3 = this.employeeRepo.create(new Employee("333333", "Sort", "Dell", BigDecimal.TEN));
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

        this.employeeRepo.create(employee1);
        this.employeeRepo.create(employee2);
        this.employeeRepo.create(employee3);
        List<Employee> sorted = this.employeeRepo.sortAllEmployees(new LastNameEmployeeComparator());
        assertNotNull(employees);

        assertEquals(employee2, sorted.get(0));
        assertEquals(employee1, sorted.get(2));
    }
}
