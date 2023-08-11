package pl.great.waw.company3.service.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.great.waw.company3.controller.EmployeeDataDto;
import pl.great.waw.company3.domain.EmployeeData;

@Mapper(componentModel = "spring")
public interface EmployeeDataMapperInterface {
    @Mapping(target="monthSalary", source="employeeData.salaryMonth")
    EmployeeDataDto employeeDataToDto(EmployeeData employeeData);
    @Mapping(target="salaryMonth", source="employeeDataDto.monthSalary")
    EmployeeData dtoToEmployeeData(EmployeeDataDto employeeDataDto);
}
