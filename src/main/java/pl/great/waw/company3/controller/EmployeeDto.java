package pl.great.waw.company3.controller;

import pl.great.waw.company3.domain.EmployeeData;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeDto {

    private String pesel;

    private String firstName;
    private String lastName;

    private BigDecimal salary;

    private List<EmployeeData> employeeDataList;

    public EmployeeDto(String pesel, String firstName, String lastName, BigDecimal salary) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public EmployeeDto() {
    }

    public String getPesel() {
        return pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
