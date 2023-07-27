package pl.great.waw.company3.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.EmployeeRepository;
import pl.great.waw.company3.repository.SalaryEmployeeComparator;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
//    @Mock
//    private EmployeeRepository employeeRepository;
//    @InjectMocks
//    private EmployeeService employeeService;
//    @Test
//    void create() {
//        Employee employee1 = new Employee("111111", "Gart", "Well", BigDecimal.ONE);
//        Mockito.when(employeeRepository.create(any(Employee.class))).thenReturn(employee1);
//        Employee employeeFromService = employeeService.create(employee1);
//        assertEquals(employee1, employeeFromService);
//    }
//    @Test
//    void get() {
//        Employee employee1 = new Employee("111111", "Gart", "Well", BigDecimal.ONE);
//        Mockito.when(employeeRepository.get(any())).thenReturn(employee1);
//        Employee employeeFromService = employeeService.get("111111");
//        assertEquals(employee1, employeeFromService);
//    }
//    @Test
//    void delete() {
//        Employee employee1 = new Employee("111111", "Gart", "Well", BigDecimal.ONE);
//        Mockito.when(employeeRepository.delete("111111")).thenReturn(true);
//        boolean removed = employeeService.delete("111111");
//        Mockito.verify(employeeRepository, Mockito.times(1)).delete("111111");
//        assertEquals(removed, true);
//    }
//    @Test
//    void update() {
//        Employee employee1 = new Employee("111111", "Gart", "Well", BigDecimal.ONE);
//        Mockito.when(employeeRepository.update(any())).thenReturn(employee1);
//        Employee employeeFromService = employeeService.update(employee1);
//        Mockito.verify(employeeRepository, Mockito.times(1)).update(employee1);
//        assertEquals(employee1,employeeFromService);
//    }
//    @Test
//    void getAll() {
//        //given
//        List<Employee> employees = List.of(new Employee("111111", "Gart", "Well", BigDecimal.ONE));
//        Mockito.when(employeeRepository.getAllEmployees()).thenReturn(employees);
//        //when
//        List<Employee> all = employeeService.getAll();
//        //then
//        Mockito.verify(employeeRepository, Mockito.times(1)).getAllEmployees();
//        assertEquals(all.size(), 1);
//        assertEquals(all.get(0), employees.get(0));
//    }
//    @Test
//    void sort() {
//        List<Employee> employees = List.of(new Employee("111111", "Gart", "Well", BigDecimal.ONE));
//        Mockito.when(employeeRepository.sortAllEmployees(any())).thenReturn(employees);
//        List<Employee> sort = this.employeeService.sort(new SalaryEmployeeComparator());
//        Mockito.verify(employeeRepository, Mockito.times(1)).sortAllEmployees(any());
//        assertEquals(employees,sort);
//    }
}