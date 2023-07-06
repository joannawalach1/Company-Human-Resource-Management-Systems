package pl.great.waw.company3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.EmployeeRepository;

import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee create(Employee employee) {
        return employeeRepository.create(employee);
    }

    public Employee get(String pesel) {
       return this.employeeRepository.get(pesel);
    }

    public boolean delete(String pesel) {
       return this.employeeRepository.delete(pesel);
    }

    public Employee update(Employee employee) {
        return this.employeeRepository.update(employee);
    }

    public List<Employee> getAll(){
        return this.employeeRepository.getAllEmployees();
    }

    public List<Employee> sort(Comparator<Employee> comparator){
        return this.employeeRepository.sortAllEmployees(comparator);
    }
}
