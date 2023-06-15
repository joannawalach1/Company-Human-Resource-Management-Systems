package pl.great.waw.company3.repository;

import pl.great.waw.company3.domain.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeRepository {
    private final List<Employee> employees = new ArrayList<>();

    public Employee getEmployee(String pesel) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (Objects.equals(pesel, employee.getPesel())){
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
}