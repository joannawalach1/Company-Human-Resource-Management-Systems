package pl.great.waw.company3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.LastNameEmployeeComparator;
import pl.great.waw.company3.repository.SalaryEmployeeComparator;
import pl.great.waw.company3.service.EmployeeService;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/{pesel}")
    public EmployeeDto getEmployee(@PathVariable String pesel) {
        return employeeService.get(pesel);
    }

    @PostMapping
    public EmployeeDto postEmployee(@RequestBody EmployeeDto employee) {
        return employeeService.create(employee);
    }

    @DeleteMapping("/{pesel}")
    public boolean deleteEmployee(@PathVariable String pesel) {
        return employeeService.delete(pesel);
    }

    @PutMapping()
    public EmployeeDto update(@RequestBody EmployeeDto employee) {
        return employeeService.update(employee);
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAll();
    }

    @PostMapping("/employees/sort")
    public List<EmployeeDto> sortedEmployees(@RequestBody SortParams sortParams) {

        Comparator<Employee> comparator = null;

        if (SortEnum.LAST_NAME.equals(sortParams.getSortEnum())) {
            comparator = new LastNameEmployeeComparator();
        } else if (SortEnum.SALARY.equals(sortParams.getSortEnum())) {
            comparator = new SalaryEmployeeComparator();
        }

        return employeeService.sort(comparator);
    }
}
