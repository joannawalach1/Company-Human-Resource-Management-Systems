package pl.great.waw.company3.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EmployeeData {

    private final Long id;
    private final String employeePesel;

    private final int month;
    private final int year;

    private final BigDecimal monthSalary;

    private final LocalDateTime created;
    private final LocalDateTime updated;

    public EmployeeData(Long id, String employeePesel, int month, int year, BigDecimal monthSalary, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.employeePesel = employeePesel;
        this.month = month;
        this.year = year;
        this.monthSalary = monthSalary;
        this.created = created;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public String getEmployeePesel() {
        return employeePesel;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}
