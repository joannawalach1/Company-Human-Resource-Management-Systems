package pl.great.waw.company3.repository;

import org.springframework.stereotype.Repository;
import pl.great.waw.company3.domain.EmployeeData;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDataRepository implements CrudRepository<EmployeeData> {

    private final List<EmployeeData> employeeDataList = new ArrayList<>();


    @Override
    public EmployeeData get(String id) {
        return null;
    }

    @Override
    public EmployeeData create(EmployeeData entity) {
        return null;
    }

    @Override
    public EmployeeData update(EmployeeData entity) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
