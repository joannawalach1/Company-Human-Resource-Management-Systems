package pl.great.waw.company3.service.mapstruct;

import org.mapstruct.Mapper;
import pl.great.waw.company3.controller.EmployeeDto;
import pl.great.waw.company3.domain.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapperInterface {

    EmployeeDto employeeToDto(Employee employee);
    Employee dtoToEmployee(EmployeeDto employeeDto);
}
