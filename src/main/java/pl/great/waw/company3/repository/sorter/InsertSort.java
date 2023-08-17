package pl.great.waw.company3.repository.sorter;

import pl.great.waw.company3.domain.Employee;

import java.util.Comparator;
import java.util.List;

public class InsertSort implements Sorter {

    @Override
    public List<Employee> sort(List<Employee> employees, Comparator<Employee> comparator) {

        int n = employees.size();

        for (int i = 1; i < n; i++) {
            Employee currentEmployee = employees.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(employees.get(j), currentEmployee) > 0) {
                employees.set(j + 1, employees.get(j));
                j--;
            }

            employees.set(j + 1, currentEmployee);
        }

        return employees;
    }

}


