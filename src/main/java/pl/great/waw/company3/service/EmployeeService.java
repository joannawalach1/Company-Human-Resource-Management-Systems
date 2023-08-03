package pl.great.waw.company3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.great.waw.company3.controller.EmployeeDataDto;
import pl.great.waw.company3.controller.EmployeeDto;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.domain.EmployeeData;
import pl.great.waw.company3.repository.EmployeeDataRepository;
import pl.great.waw.company3.repository.EmployeeRepository;
import pl.great.waw.company3.service.mapper.EmployeeDataMapper;
import pl.great.waw.company3.service.mapper.EmployeeMapper;

import java.math.BigDecimal;
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

    @Autowired
    private EmployeeDataMapper employeeDataMapper;

    public EmployeeDto create(EmployeeDto dto) {
        Employee employee = employeeMapper.fromDto(dto);
        Employee employeeSaved1 = employeeRepository.create(employee);
        return employeeMapper.toDto(employeeSaved1);
    }

    public EmployeeDataDto createData(EmployeeDataDto employeeDataDto) {
        EmployeeData employeeData = employeeDataMapper.fromDto(employeeDataDto);
        EmployeeData employeeSaved2 = employeeDataRepository.createData(employeeData);
        return employeeDataMapper.toDto(employeeSaved2);
    }

    public EmployeeDto get(String pesel) {
        return this.employeeMapper.toDto(this.employeeRepository.get(pesel));
    }

    public List<EmployeeDataDto> getData(String pesel) {
        return this.employeeDataRepository.getData(pesel)
                .stream()
                .map(EmployeeDataMapper::toDto)
                .collect(Collectors.toList());
    }

    public BigDecimal totalYearlySalary(String pesel, int year) {
        List<EmployeeData> yearlyData = this.employeeDataRepository.getYearlyData(pesel, year);
         return yearlyData.stream()
                .map(EmployeeData::getSalaryMonth)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
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
