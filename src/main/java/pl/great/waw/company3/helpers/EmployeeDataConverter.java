package pl.great.waw.company3.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.great.waw.company3.domain.EmployeeData;
import pl.great.waw.company3.repository.EmployeeDataRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class EmployeeDataConverter {

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<EmployeeData> loadEmployeeData(String path) throws IOException {
        String employeeJson = Files.readString(Path.of(path));
        List<EmployeeData> employeeDatas = objectMapper.readValue(employeeJson, new TypeReference<>() {
        });

        employeeDataRepository.createAll(employeeDatas);
        return employeeDatas;
    }

    public void cacheEmployeeData(String path) throws IOException {
        List<EmployeeData> allEmployees = employeeDataRepository.getAll();

        Path fileName = Path.of(path);
        String s = objectMapper.writeValueAsString(allEmployees);

        Files.writeString(fileName, s);
    }
}
