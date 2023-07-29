package pl.great.waw.company3.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.EmployeeRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class EmployeeConverter {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public void loadEmployee(String path) throws IOException {
        String employeeJson = Files.readString(Path.of(path));
        List<Employee> employees = objectMapper.readValue(employeeJson, new TypeReference<List<Employee>>() {
        });

        employeeRepository.createAll(employees);
    }

    public void cacheEmployee(String path) throws IOException {
        List<Employee> allEmployees = employeeRepository.getAllEmployees();

        Path fileName = Path.of(path);
        String s = objectMapper.writeValueAsString(allEmployees);

        Files.writeString(fileName, s);
    }
}
