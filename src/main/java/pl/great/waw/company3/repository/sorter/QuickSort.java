package pl.great.waw.company3.repository.sorter;

import pl.great.waw.company3.domain.Employee;

import java.util.Comparator;
import java.util.List;

public class QuickSort implements Sorter {

    @Override
    public List<Employee> sort(List<Employee> employees, Comparator<Employee> comparator) {
        employees.sort(comparator);

        return employees;
    }
}
