package pl.great.waw.company3.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Employee {

    private String pesel;

    private String firstName;
    private String lastName;

    private BigDecimal salary;

    private LocalDateTime created;
    private LocalDateTime modified;

    public Employee(String pesel, String firstName, String lastName, BigDecimal salary) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
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

    public LocalDateTime getModified() {
        return modified;
    }
}
