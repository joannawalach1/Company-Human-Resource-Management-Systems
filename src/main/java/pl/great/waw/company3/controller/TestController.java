package pl.great.waw.company3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.EmployeeRepository;

import java.math.BigDecimal;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("{n}")
    public void generateEmpl(@PathVariable int n) {

        for (int i = n; i > 0; i--) {
            employeeRepository.create(new Employee(""+i,"A"+i,"B"+i, BigDecimal.valueOf(i)));
        }
    }
}
