package pl.great.waw.company3.controller;

import pl.great.waw.company3.domain.EmployeeData;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class EmployeeDto {

    private String pesel;

    private String firstName;
    private String lastName;

    private BigDecimal salary;

    private List<EmployeeData> employeeDataList;

    public EmployeeDto(String pesel, String firstName, String lastName, BigDecimal salary, List<EmployeeData> employeeDataList) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.employeeDataList = employeeDataList;
    }

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

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<EmployeeData> getEmployeeDataList() {
        return employeeDataList;
    }

    public void setEmployeeDataList(List<EmployeeData> employeeDataList) {
        this.employeeDataList = employeeDataList;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(pesel, that.pesel) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(salary, that.salary) && Objects.equals(employeeDataList, that.employeeDataList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel, firstName, lastName, salary, employeeDataList);
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "pesel='" + pesel + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", employeeDataList=" + employeeDataList +
                '}';
    }
}
