package pl.great.waw.company3.repository;

import org.springframework.stereotype.Repository;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.sorter.BubbleSort;
import pl.great.waw.company3.repository.sorter.Sorter;

import java.util.*;

@Repository
public class EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();

    private Sorter sorter = new BubbleSort();

    public Employee get(String pesel) {
        for (Employee employee : employees) {
            if (Objects.equals(pesel, employee.getPesel())) {
                return employee;
            }
        }
        return null;
    }

    public Employee create(Employee employee) {
        Employee emp = get(employee.getPesel());
        if (emp != null) {
            throw new IllegalArgumentException("Pesel already exists " + employee.getPesel());
        }
        employees.add(employee);
        return employee;
    }

    public void createAll(List<Employee> employeeToCreate){
        employees.addAll(employeeToCreate);
    }

    public boolean delete(String pesel) {
        Employee emp = get(pesel);
        if (emp == null) {
            throw new IllegalArgumentException("Pesel doesn't exist" + pesel);
        }
        int i = this.employees.indexOf(emp);
        return this.employees.remove(i) != null;
    }

    public void deleteAll(){
        this.employees.clear();
    }

    public Employee update(Employee employee) {
        Employee emp1 = this.get(employee.getPesel());

        if (emp1 == null) {
            throw new IllegalArgumentException("employee doesn't found with pesel " + employee.getPesel());
        }

        int index = this.employees.indexOf(emp1);
        this.employees.set(index, employee);

        Employee persistedEmployee = get(employee.getPesel());

        return new Employee(
                persistedEmployee.getPesel(),
                persistedEmployee.getFirstName(),
                persistedEmployee.getLastName(),
                persistedEmployee.getSalary()
        );
    }

    public List<Employee> sortEmployees(Sorter sorter, List<Employee> employees, Comparator<Employee> comparator) {
        return sorter.sort(employees, comparator);
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Employee> sortAllEmployees( Comparator<Employee> comparator) {

        return sorter.sort(getAllEmployees(), comparator);
    }
}