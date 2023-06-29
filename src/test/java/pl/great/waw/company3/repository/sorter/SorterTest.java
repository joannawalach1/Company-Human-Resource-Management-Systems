package pl.great.waw.company3.repository.sorter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.LastNameEmployeeComparator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {

    private List<Sorter> sorterList;

    @BeforeEach
    public void setup() {
        sorterList = Arrays.asList(new BubbleSort(), new InsertSort(), new QuickSort());
    }

    @Test
    void sortPerformance() {
        Random random = new Random();
        int value = random.nextInt(10000000);

        Employee employee = new Employee("23456", "Steve", String.valueOf(value), BigDecimal.ONE);
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            employees.add(employee);
        }
        for (Sorter sorter : sorterList) {
            long startTime = System.nanoTime();
            sorter.sort(employees, new LastNameEmployeeComparator());
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println(sorter + "Czas sortowania: " + duration + " μs");
        }
    }

    @Test
    void testSort() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 100; i > 0; i--) {
            employees.add(new Employee("23456", "Steve", String.valueOf(i), BigDecimal.ONE));
        }

        sorterList.forEach( (sorter -> {
            List<Employee> list = sorter.sort(employees, new LastNameEmployeeComparator());
            Employee first = list.get(0);
            Employee last = list.get(list.size() - 1);
            assertEquals(first.getLastName(), "1");
            assertEquals(last.getLastName(), "99");
        }
        ));
    }
}