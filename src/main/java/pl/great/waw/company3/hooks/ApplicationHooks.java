package pl.great.waw.company3.hooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.great.waw.company3.helpers.EmployeeConverter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Component
public class ApplicationHooks {

    public static final String EMPLOYEE_JSON_PATH = "src/main/resources/employee.json";

    @Autowired
    private EmployeeConverter employeeConverter;

    @PostConstruct
    public void onInit() throws IOException {
        employeeConverter.loadEmployee(EMPLOYEE_JSON_PATH);
    }

    @PreDestroy
    public void onClose() throws IOException {
        employeeConverter.cacheEmployee(EMPLOYEE_JSON_PATH);
    }
}
