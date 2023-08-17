package pl.great.waw.company3.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.great.waw.company3.configuration.SpringConfiguration;
import pl.great.waw.company3.domain.EmployeeData;
import pl.great.waw.company3.repository.EmployeeDataRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {SpringConfiguration.class, EmployeeDataConverter.class, EmployeeDataRepository.class})
@ActiveProfiles("test")
class EmployeeDataConverterTest {

    private static final String TEST_ID = "1";
    private static final String TEST_EMPLOYEE_PESEL = "234567890";
    private static final int TEST_MONTH = 10;
    private static final int TEST_YEAR = 2023;
    private static final BigDecimal TEST_SALARY = BigDecimal.valueOf(2300);
    private static final LocalDateTime TEST_CREATED = LocalDateTime.now();
    private static final LocalDateTime TEST_UPDATED = LocalDateTime.now();

    public static final String TEST_LOAD_EMPLOYEE_JSON_PATH = "src/test/resources/test_employee_data_loading.json";
    public static final String TEST_CACHE_EMPLOYEE_JSON_PATH = "src/test/resources/test_employee_data_cache.json";

    @Autowired
    private EmployeeDataConverter employeeDataConverter;

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @BeforeEach
    void setup() {
        employeeDataRepository.deleteAll();
    }

    @Test
    void loadEmployee() throws IOException {
        employeeDataConverter.loadEmployeeData(TEST_LOAD_EMPLOYEE_JSON_PATH);
        List<EmployeeData> allEmployees = employeeDataRepository.getAll();

        assertEquals(allEmployees.size(), 1);
    }

    @Test
    void cacheEmployee() throws IOException {
        this.employeeDataRepository.createData(new EmployeeData(TEST_ID, TEST_EMPLOYEE_PESEL, TEST_MONTH, TEST_YEAR, TEST_SALARY, TEST_CREATED, TEST_UPDATED));
        employeeDataConverter.cacheEmployeeData(TEST_CACHE_EMPLOYEE_JSON_PATH);
    }
}