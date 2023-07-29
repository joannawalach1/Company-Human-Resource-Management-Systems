package pl.great.waw.company3.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.great.waw.company3.domain.Employee;
import pl.great.waw.company3.repository.EmployeeRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.Files.writeString;

@Component
public class EmployeeConverter {

    private EmployeeRepository employeeRepository;

   private ObjectMapper objectMapper;

    public void loadEmployee(String path) throws IOException {
        String employeeJson = Files.readString(Path.of(path));
        List<Employee> employees = objectMapper.readValue(employeeJson, new TypeReference<List<Employee>>() {});

        employeeRepository.createAll(employees);
    }

    public void cacheEmployee(String path) throws IOException {
        List<Employee> allEmployees = employeeRepository.getAllEmployees();

        Path fileName = Path.of(path);
        String s = objectMapper.writeValueAsString(allEmployees);

        writeString(fileName, s);
    }
}
