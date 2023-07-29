package pl.great.waw.company3.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.great.waw.company3.domain.EmployeeData;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDataRepositoryTest {

    private EmployeeDataRepository employeeDataRepository;
    private final List<EmployeeData> employeeDataList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        employeeDataRepository = new EmployeeDataRepository();
        EmployeeData employeeData1 = new EmployeeData("1","1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now());
        EmployeeData employeeData2 = new EmployeeData("2","1234567890", 5, 2023, BigDecimal.valueOf(5600), LocalDateTime.now(), LocalDateTime.now());

    }

    @Test
    public void testCreateData() {
        EmployeeData employeeData = new EmployeeData("1","1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now());
        EmployeeData result = employeeDataRepository.createData(employeeData);

        assertNotNull(result);
        assertEquals(employeeData, result);
        assertEquals(1, employeeDataRepository.sizeData());
    }

    @Test
    public void testGetData() {
        String employeeId = "1";
        EmployeeData employeeData1 = new EmployeeData("1","1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now());
        EmployeeData employeeData2 = new EmployeeData("2","1234567891", 5, 2023, BigDecimal.valueOf(5600), LocalDateTime.now(), LocalDateTime.now());

        employeeDataRepository.createData(employeeData1);
        employeeDataRepository.createData(employeeData2);

        List<EmployeeData> result = employeeDataRepository.getData(employeeId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains(employeeData1));
        assertFalse(result.contains(employeeData2));
    }

    @Test
    public void testUpdateData() {
        String employeeId = "1";
        EmployeeData employeeData1 = new EmployeeData("1","1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now());
        EmployeeData employeeData2 = new EmployeeData("1","1234567891", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now());

        employeeDataRepository.createData(employeeData1);
        employeeDataRepository.createData(employeeData2);

        EmployeeData updatedData = new EmployeeData("1","1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now());

        EmployeeData result = employeeDataRepository.updateData(employeeId, updatedData);

        assertNotNull(result);
        assertEquals(updatedData, result);

        List<EmployeeData> dataList = employeeDataRepository.getData(employeeId);
        assertEquals(2, dataList.size());

    }

    @Test
    public void testDeleteData() {
        String employeeId = "1";
        EmployeeData employeeData1 = new EmployeeData("1","1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now());
        EmployeeData employeeData2 = new EmployeeData("1","1234567891", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now());

        employeeDataRepository.createData(employeeData1);
        employeeDataRepository.createData(employeeData2);

        employeeDataRepository.deleteData(employeeId);

        List<EmployeeData> dataList = employeeDataRepository.getData(employeeId);
        assertTrue(dataList.isEmpty());
        assertEquals(0, employeeDataRepository.sizeData());
    }

    @Test
    public void testGetAll() {
        EmployeeData employeeData1 = new EmployeeData("1","1234567890", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now());
        EmployeeData employeeData2 = new EmployeeData("1","1234567891", 4, 2023, BigDecimal.valueOf(5400), LocalDateTime.now(), LocalDateTime.now());

        employeeDataRepository.createData(employeeData1);
        employeeDataRepository.createData(employeeData2);

        List<EmployeeData> result = employeeDataRepository.getAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(employeeData1));
        assertTrue(result.contains(employeeData2));
    }


//    @Test
//    public void testCreateWithExistingPesel() {
//        EmployeeData entity1 = new EmployeeData("1", "0123456789", 4, 2023, BigDecimal.valueOf(5000), LocalDateTime.now(), LocalDateTime.now());
//        EmployeeData entity2 = new EmployeeData("1", "0123456789", 5, 2023, BigDecimal.valueOf(5200), LocalDateTime.now(), LocalDateTime.now());
//        employeeDataList.add(entity1);
//        employeeDataList.add(entity2);
//
//        try {
//            employeeDataRepository.createData(entity1);
//            fail("Expected IllegalArgumentException to be thrown, but nothing was thrown.");
//        } catch (IllegalArgumentException e) {
//            assertEquals("Pesel exists: " + entity1.getEmployeePesel(), e.getMessage());
//        }
//    }
}