package pl.great.waw.company3.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Employee implements Comparable<Employee> {

    private String pesel;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDateTime created;
    private LocalDateTime modified;

    public Employee(String pesel, String firstName, String lastName, BigDecimal salary, List<EmployeeData> employeeDataList) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }

    public Employee(String pesel, String firstName, String lastName, BigDecimal salary) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }

    public Employee() {
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(pesel, employee.pesel) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(salary, employee.salary) && Objects.equals(created, employee.created) && Objects.equals(modified, employee.modified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel, firstName, lastName, salary, created, modified);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "pesel='" + pesel + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        return this.getPesel().compareTo(employee.getPesel());
    }
}
