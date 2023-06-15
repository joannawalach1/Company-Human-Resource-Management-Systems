package pl.great.waw.company3.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void getPesel() {
        Employee employee = new Employee("8787878787", "pawel", "sz", BigDecimal.ONE);

        assertEquals( employee.getPesel(),"8787878787" );
        assertEquals( employee.getFirstName(),"pawel" );
        assertEquals( employee.getLastName(),"sz" );
        assertEquals( employee.getSalary(),BigDecimal.ONE );
    }
}