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
import pl.great.waw.company3.service.mapstruct.EmployeeDataMapperInterface;
import pl.great.waw.company3.service.mapstruct.EmployeeMapperInterface;

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
    private EmployeeMapperInterface employeeMapperInterface;
    //private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeDataMapperInterface employeeDataMapperInterface;
    // private EmployeeDataMapper employeeDataMapper;

    public EmployeeDto create(EmployeeDto dto) {
        Employee employee = employeeMapperInterface.dtoToEmployee(dto);
        Employee employeeSaved1 = employeeRepository.create(employee);
        return employeeMapperInterface.employeeToDto(employeeSaved1);
    }

    public EmployeeDataDto createData(EmployeeDataDto employeeDataDto) {
        EmployeeData employeeData = employeeDataMapperInterface.dtoToEmployeeData(employeeDataDto);
        EmployeeData employeeSaved2 = employeeDataRepository.createData(employeeData);
        return employeeDataMapperInterface.employeeDataToDto(employeeSaved2);
    }

    public EmployeeDto get(String pesel) {
        return this.employeeMapperInterface.employeeToDto(this.employeeRepository.get(pesel));
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

    public BigDecimal monthlySalaryInYear(String pesel, int year, int month) {
        List<EmployeeData> monthData = this.employeeDataRepository.getMonthlyData(pesel, year, month);
        return monthData.stream()
                .map(EmployeeData::getSalaryMonth)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal totalSalaryForEmp(String pesel) {
        List<EmployeeData> totalSalary = this.employeeDataRepository.getTotalSalaryForEmp(pesel);
        return totalSalary.stream()
                .map(EmployeeData::getSalaryMonth)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean delete(String pesel) {
        return this.employeeRepository.delete(pesel);
    }

    public EmployeeDto update(EmployeeDto employeeDto) {
        Employee employee = this.employeeMapperInterface.dtoToEmployee(employeeDto);
        return this.employeeMapperInterface.employeeToDto(this.employeeRepository.update(employee));
    }

    public List<EmployeeDto> getAll() {
        return employeeRepository.getAllEmployees()
                .stream()
                .map(employee -> employeeMapperInterface.employeeToDto(employee))
                .collect(Collectors.toList());
    }

    public List<EmployeeDto> sort(Comparator<Employee> comparator) {
        return this.employeeRepository.sortAllEmployees(comparator)
                .stream()
                .map(employee -> employeeMapperInterface.employeeToDto(employee))
                .collect(Collectors.toList());
    }
}
