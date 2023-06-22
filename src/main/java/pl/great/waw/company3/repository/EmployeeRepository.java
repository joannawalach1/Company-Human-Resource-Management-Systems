package pl.great.waw.company3.repository;

import pl.great.waw.company3.domain.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    public Employee getEmployee(String pesel) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (Objects.equals(pesel, employee.getPesel())) {
                return employee;
            }
        }
        return null;
    }

    public Employee createEmployee(Employee employee) {
        Employee emp = getEmployee(employee.getPesel());
        if (emp != null) {
            throw new IllegalArgumentException("Pesel already exists" + employee.getPesel());
        }
        employees.add(employee);
        return employee;
    }

    public boolean deleteEmployee(String pesel) {
        Employee emp = getEmployee(pesel);
        if (emp == null) {
            throw new IllegalArgumentException("Pesel doesn't exist" + pesel);
        }
        int i = this.employees.indexOf(emp);
        return this.employees.remove(i) != null;
    }

    public Employee updateEmployee(Employee employee) {
        Employee emp1 = this.getEmployee(employee.getPesel());

        if (emp1 == null) {
            throw new IllegalArgumentException("employee dont found with pesel " + employee.getPesel());
        }

        int index = this.employees.indexOf(emp1);
        this.employees.set(index, employee);

        Employee persistedEmployee = getEmployee(employee.getPesel());

        return new Employee(
                persistedEmployee.getPesel(),
                persistedEmployee.getFirstName(),
                persistedEmployee.getLastName(),
                persistedEmployee.getSalary()
        );
    }
}