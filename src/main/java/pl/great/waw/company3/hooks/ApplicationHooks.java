package pl.great.waw.company3.hooks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.great.waw.company3.helpers.EmployeeConverter;
import pl.great.waw.company3.helpers.EmployeeDataConverter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Component
public class ApplicationHooks {

    public static String EMPLOYEE_JSON_PATH = "src/main/resources/employee.json";
    public static String EMPLOYEE_JSON_DATA_PATH = "src/main/resources/employee_Data.json";

    @Autowired
    private EmployeeConverter employeeConverter;

    @Autowired
    private EmployeeDataConverter employeeDataConverter;

    @PostConstruct
    public void onInit() throws IOException {
        employeeConverter.loadEmployee(EMPLOYEE_JSON_PATH);
        employeeDataConverter.loadEmployeeData(EMPLOYEE_JSON_DATA_PATH);
    }

    @PreDestroy
    public void onClose() throws IOException {
        employeeConverter.cacheEmployee(EMPLOYEE_JSON_PATH);
        employeeDataConverter.cacheEmployeeData(EMPLOYEE_JSON_DATA_PATH);
    }
}
