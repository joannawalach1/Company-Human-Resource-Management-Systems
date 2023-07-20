package pl.great.waw.company3.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.great.waw.company3.configuration.SpringConfiguration;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.EmployeeRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {SpringConfiguration.class, EmployeeConverter.class, EmployeeRepository.class})
@ActiveProfiles("test")
class EmployeeConverterTest {

    private static final String TEST_PESEL = "23456";
    private static final String TEST_FIRSTNAME = "Steve";
    private static final String TEST_LASTNAME = "Brown";

    public static final String TEST_LOAD_EMPLOYEE_JSON_PATH = "src/test/resources/test_employee_load.json";
    public static final String TEST_CACHE_EMPLOYEE_JSON_PATH = "src/test/resources/test_employee_cache.json";

    @Autowired
    private EmployeeConverter employeeConverter;

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setup() {
        employeeRepository.deleteAll();
    }

    @Test
    void loadEmployee() throws IOException {
        employeeConverter.loadEmployee(TEST_LOAD_EMPLOYEE_JSON_PATH);
        List<Employee> allEmployees = employeeRepository.getAllEmployees();

        assertEquals(allEmployees.size(), 2);
    }

    @Test
    void cacheEmployee() throws IOException {
        this.employeeRepository.create(new Employee(TEST_PESEL, TEST_FIRSTNAME, TEST_LASTNAME, BigDecimal.ONE));
        employeeConverter.cacheEmployee(TEST_CACHE_EMPLOYEE_JSON_PATH);
    }
}