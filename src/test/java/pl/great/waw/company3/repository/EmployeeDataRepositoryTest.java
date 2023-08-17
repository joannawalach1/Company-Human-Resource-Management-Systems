package pl.great.waw.company3.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.great.waw.company3.domain.EmployeeData;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class EmployeeDataRepositoryTest {

    private EmployeeDataRepository employeeDataRepository = new EmployeeDataRepository();

    @BeforeEach
    public void setUp() {
        List<EmployeeData> employeeDataList = new ArrayList<>();
        EmployeeData emp1 = employeeDataRepository.createData(new EmployeeData("1", "1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now()));
        EmployeeData emp2 = employeeDataRepository.createData(new EmployeeData("2", "1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now()));

    }

    @Test
    public void testCreateData() {
        EmployeeData result = employeeDataRepository.createData(new EmployeeData("3", "1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now()));
        assertNotNull(result);
    }

//    @Test
//    public void testCreateWithExistingPesel() {
//        try {
//            EmployeeData result = employeeDataRepository.createData((new EmployeeData("1", "1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now()));
//            fail("Expected IllegalArgumentException to be thrown, but nothing was thrown.");
//        } catch (IllegalArgumentException e) {
//            assertEquals("Pesel exists: " + result. , e.getMessage());
//        }
//    }

    @Test
    public void testGetData() {
        String pesel = "1";
        List<EmployeeData> result = employeeDataRepository.getData(pesel);
        assertNotNull(result);
        assertFalse(result.contains(pesel));
    }

    @Test
    public void testUpdateData() {
        String employeeId = "1";

        EmployeeData updatedData = new EmployeeData("1", "1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now());

        EmployeeData result = employeeDataRepository.updateData(employeeId, updatedData);

        assertNotNull(result);
        assertEquals(updatedData, result);
    }

    @Test
    public void testDeleteData() {
        String employeeId = "1";

        employeeDataRepository.deleteData(employeeId);

        List<EmployeeData> dataList = employeeDataRepository.getData(employeeId);
        assertTrue(dataList.isEmpty());
        assertEquals(0, dataList.size());
    }

    @Test
    public void testGetAll() {
        List<EmployeeData> result = employeeDataRepository.getAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(result.get(0)));
        assertTrue(result.contains(result.get(1)));
    }
}