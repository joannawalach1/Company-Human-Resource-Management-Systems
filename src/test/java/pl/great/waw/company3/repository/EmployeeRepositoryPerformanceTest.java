package pl.great.waw.company3.repository;

import org.junit.Test;
import pl.great.waw.company3.domain.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryPerformanceTest {
    private final EmployeeRepository employeeRepo = new EmployeeRepository();
//
//    @Test
//    public void testSortBigDecimalsPerformance() {
//        EmployeeRepository repository = new EmployeeRepository();
//        List<Employee> employees = new ArrayList<>();
//        this.employeeRepo.createEmployee(new Employee("23456", "Steve", "Brown", BigDecimal.valueOf(100, 50)));
//        this.employeeRepo.createEmployee(new Employee("22222", "Anna", "Zieliński", BigDecimal.valueOf(12, 44)));
//        this.employeeRepo.createEmployee(new Employee("44444", "John", "Smith", BigDecimal.valueOf(44, 78)));
//        this.employeeRepo.createEmployee(new Employee("45656", "Mia", "Dog", BigDecimal.valueOf(77, 33)));
//        this.employeeRepo.createEmployee(new Employee("33333", "Joe", "Powell", BigDecimal.valueOf(88, 65)));
//
//        long startTime = System.nanoTime();
//        repository.sortBigDecimals(employees);
//        long endTime = System.nanoTime();
//        long duration = endTime - startTime;
//        System.out.println("Czas sortowanie BigDecimals: " + duration + " μs");
//    }
//
//    @Test
//    public void testSortBubblePerformance() {
//        long startTime = System.nanoTime();
//        List<Comparable<Employee>> employees;
//        employees = new ArrayList<>();
//        this.employeeRepo.createEmployee(new Employee("22222", "Anna", "Zieliński", BigDecimal.valueOf(52, 44)));
//        this.employeeRepo.createEmployee(new Employee("44444", "John", "Smith", BigDecimal.valueOf(66, 78)));
//        this.employeeRepo.createEmployee(new Employee("45656", "Mia", "Dog", BigDecimal.valueOf(34, 33)));
//        this.employeeRepo.createEmployee(new Employee("33333", "Joe", "Powell", BigDecimal.valueOf(65, 65)));
//
//        employeeRepo.sortBubble(employees);
//        long endTime = System.nanoTime();
//        long duration = endTime - startTime;
//        System.out.println("Czas sortowanie BUBBLE SORT: " + duration + " μs");
//
//    }
//
//    @Test
//    public void testAddEmployeePerformance() {
//        long startTime = System.nanoTime();
//        this.employeeRepo.createEmployee(new Employee("2222211", "Anna", "Zieliński", BigDecimal.valueOf(52, 44)));
//        this.employeeRepo.createEmployee(new Employee("989121899", "John", "Smith", BigDecimal.valueOf(66, 78)));
//        this.employeeRepo.createEmployee(new Employee("676723267", "Mia", "Dog", BigDecimal.valueOf(34, 33)));
//        this.employeeRepo.createEmployee(new Employee("111111", "Joe", "Powell", BigDecimal.valueOf(67, 90)));
//        long endTime = System.nanoTime();
//        long duration = endTime - startTime;
//        System.out.println("Czas dodawania pracowników: " + duration + " μs");
//    }
//
//    @Test
//    public void testDeleteEmployeePerformance() {
//        long startTime = System.nanoTime();
//
//        this.employeeRepo.createEmployee(new Employee("22222", "Anna", "Zieliński", BigDecimal.valueOf(52, 44)));
//        this.employeeRepo.createEmployee(new Employee("44444", "John", "Smith", BigDecimal.valueOf(66, 78)));
//        this.employeeRepo.createEmployee(new Employee("45656", "Mia", "Dog", BigDecimal.valueOf(34, 33)));
//        this.employeeRepo.createEmployee(new Employee("33333", "Joe", "Powell", BigDecimal.valueOf(65, 65)));
//        this.employeeRepo.deleteEmployee(("22222"));
//        this.employeeRepo.deleteEmployee(("44444"));
//        this.employeeRepo.deleteEmployee(("45656"));
//        this.employeeRepo.deleteEmployee(("33333"));
//
//        long endTime = System.nanoTime();
//        long duration = endTime - startTime;
//        System.out.println("Czas usunięcia pracowników: " + duration + " μs");
//    }
}
