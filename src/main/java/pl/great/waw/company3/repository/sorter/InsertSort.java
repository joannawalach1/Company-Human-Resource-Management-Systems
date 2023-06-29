package pl.great.waw.company3.repository.sorter;

import pl.great.waw.company3.domain.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertSort implements Sorter {

    @Override
    public List<Employee> sort(List<Employee> employees, Comparator<Employee> comparator) {

        int n = employees.size();
        int i;

        Employee[] employeeArray = employees.toArray(new Employee[n]);

        for (i = 1; i < n; i++) {
            Employee number = employeeArray[i];

            int j = i - 1;
            while (j >= 0 && employeeArray[j].getSalary().compareTo(number.getSalary()) > 0) {
                employeeArray[j + 1] = employeeArray[j];
                j--;
            }
            employeeArray[j + 1] = number;
        }

        return Arrays.asList(employeeArray);
    }

}


