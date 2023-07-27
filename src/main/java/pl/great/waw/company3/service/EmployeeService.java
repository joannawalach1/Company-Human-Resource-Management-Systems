package pl.great.waw.company3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.great.waw.company3.controller.EmployeeDto;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.EmployeeDataRepository;
import pl.great.waw.company3.repository.EmployeeRepository;
import pl.great.waw.company3.service.mapper.EmployeeMapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDto create(EmployeeDto dto) {
        Employee employee = employeeMapper.fromDto(dto);

        Employee employeeSaved = employeeRepository.create(employee);
        return employeeMapper.toDto(employeeSaved);
    }

    public EmployeeDto get(String pesel) {
        return this.employeeMapper.toDto(this.employeeRepository.get(pesel));
    }

    public boolean delete(String pesel) {
        return this.employeeRepository.delete(pesel);
    }

    public EmployeeDto update(EmployeeDto employeeDto) {
        Employee employee = this.employeeMapper.fromDto(employeeDto);
        return this.employeeMapper.toDto(this.employeeRepository.update(employee));
    }

    public List<EmployeeDto> getAll() {

        return employeeRepository.getAllEmployees()
                .stream()
                .map(employee -> employeeMapper.toDto(employee))
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> sort(Comparator<Employee> comparator) {

        return this.employeeRepository.sortAllEmployees(comparator)
                .stream()
                .map(employee -> employeeMapper.toDto(employee))
                .collect(Collectors.toList());
    }
}
