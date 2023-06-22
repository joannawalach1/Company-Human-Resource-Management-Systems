package pl.great.waw.company3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.EmployeeRepository;

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
}
