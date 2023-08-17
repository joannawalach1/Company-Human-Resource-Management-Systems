package pl.great.waw.company3.service.mapper;

import org.springframework.stereotype.Component;
import pl.great.waw.company3.controller.EmployeeDataDto;
import pl.great.waw.company3.domain.EmployeeData;

@Component
public class EmployeeDataMapper {
    public static EmployeeDataDto toDto(EmployeeData employeeData) {
        return new EmployeeDataDto(
                employeeData.getId(),
                employeeData.getEmployeePesel(),
                employeeData.getMonth(),
                employeeData.getYear(),
                employeeData.getSalaryMonth(),
                employeeData.getCreated(),
                employeeData.getUpdated());
    }

    public static EmployeeData fromDto(EmployeeDataDto employeeDataDto) {
        return new EmployeeData(
                employeeDataDto.getId(),
                employeeDataDto.getEmployeePesel(),
                employeeDataDto.getMonth(),
                employeeDataDto.getYear(),
                employeeDataDto.getMonthSalary(),
                employeeDataDto.getCreated(),
                employeeDataDto.getUpdated());

    }
}
