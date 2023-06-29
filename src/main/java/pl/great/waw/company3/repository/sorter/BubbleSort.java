package pl.great.waw.company3.repository.sorter;

import pl.great.waw.company3.domain.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BubbleSort implements Sorter {

    @Override
    public List<Employee> sort(List<Employee> employees, Comparator<Employee> comparator) {

        int n = employees.size();

        Employee[] employeeArray = employees.toArray(new Employee[n]);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {

                if (comparator.compare(employeeArray[j], employeeArray[j + 1]) > 0) {
                    Employee temp = employeeArray[j];
                    employeeArray[j] = employeeArray[j + 1];
                    employeeArray[j + 1] = temp;
                }
            }
        }

        return Arrays.asList(employeeArray);
    }
}