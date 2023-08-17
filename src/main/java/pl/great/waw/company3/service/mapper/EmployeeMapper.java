package pl.great.waw.company3.service.mapper;

import org.springframework.stereotype.Component;
import pl.great.waw.company3.controller.EmployeeDto;
import pl.great.waw.company3.domain.Employee;

@Component
public class EmployeeMapper {


    public Employee fromDto(EmployeeDto dto) {
        return new Employee(dto.getPesel(), dto.getFirstName(), dto.getLastName(), dto.getSalary());
    }

    public EmployeeDto toDto(Employee employee) {
        return new EmployeeDto(employee.getPesel(), employee.getFirstName(), employee.getLastName(), employee.getSalary());
    }
}
