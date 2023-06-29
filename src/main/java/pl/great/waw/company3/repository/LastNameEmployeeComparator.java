package pl.great.waw.company3.repository;

import pl.great.waw.company3.domain.Employee;

import java.util.Comparator;

public class LastNameEmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
