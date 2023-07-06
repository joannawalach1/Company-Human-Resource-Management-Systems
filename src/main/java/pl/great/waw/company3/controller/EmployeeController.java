package pl.great.waw.company3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.EmployeeRepository;
import pl.great.waw.company3.repository.LastNameEmployeeComparator;
import pl.great.waw.company3.repository.SalaryEmployeeComparator;
import pl.great.waw.company3.repository.sorter.BubbleSort;
import pl.great.waw.company3.repository.sorter.Sorter;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "/{pesel}")
    public Employee getEmployee(@PathVariable String pesel) {
        return employeeRepository.getEmployee(pesel);
    }

    @PostMapping
    public Employee postEmployee(@RequestBody Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    @DeleteMapping("/{pesel}")
    public boolean deleteEmployee(@PathVariable String pesel) {
        return employeeRepository.deleteEmployee(pesel);
    }

    @PutMapping()
    public Employee update(@RequestBody Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @PostMapping("/employees/sort")
    public List<Employee> sortedEmployees(@RequestBody SortParams sortParams) {

        Comparator<Employee> comparator = null;

        if (SortEnum.LAST_NAME.equals(sortParams.getSortEnum())) {
            comparator = new LastNameEmployeeComparator();
        } else if (SortEnum.SALARY.equals(sortParams.getSortEnum())) {
            comparator = new SalaryEmployeeComparator();
        }

        return employeeRepository.sortAllEmployees(comparator);
    }
}
