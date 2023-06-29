package pl.great.waw.company3.repository.sorter;

import pl.great.waw.company3.domain.Employee;

import java.util.Comparator;
import java.util.List;

public interface Sorter {
    List<Employee> sort(List<Employee> employees, Comparator<Employee> comparator);
}
