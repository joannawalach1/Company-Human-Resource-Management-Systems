package pl.great.waw.company3.repository;

import pl.great.waw.company3.domain.Employee;

import java.util.Comparator;

public class SalaryEmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary().compareTo(o2.getSalary());
    }
}
