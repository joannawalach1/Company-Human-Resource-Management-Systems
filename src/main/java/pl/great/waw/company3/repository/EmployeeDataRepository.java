package pl.great.waw.company3.repository;

import org.springframework.stereotype.Repository;
import pl.great.waw.company3.domain.EmployeeData;
import pl.great.waw.company3.repository.sorter.BubbleSort;
import pl.great.waw.company3.repository.sorter.Sorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EmployeeDataRepository {

    private final List<EmployeeData> employeeDataFromRepo = new ArrayList<>();
    private final Sorter sorter = new BubbleSort();

    public EmployeeData createData(EmployeeData employeeData) {
        String pesel = employeeData.getEmployeePesel();

        //TODO sprawdzenie czy pesel istnieje, musi być w liście employee
//        boolean peselExists = employeeDataFromRepo.stream()
//                .anyMatch(data -> data.getEmployeePesel().equals(pesel));
//
//        if (peselExists) {
//            throw new IllegalArgumentException("Pesel exists: " + pesel);
//        }

        employeeDataFromRepo.add(employeeData);
        return employeeData;
    }

    private boolean peselExists(String pesel) {
        return employeeDataFromRepo
                .stream()
                .anyMatch(data -> data.getEmployeePesel().equals(pesel));
    }

    public void createAll(List<EmployeeData> employeesToCreate){
        employeeDataFromRepo.addAll(employeesToCreate);
    }
    public List<EmployeeData> getData(String pesel) {
        return employeeDataFromRepo.stream()
                .filter(employeeData -> employeeData.getEmployeePesel().equals(pesel))
                .collect(Collectors.toList());
    }

    public List<EmployeeData> getYearlyData(String pesel, int year) {
        return employeeDataFromRepo.stream()
                .filter(employeeData -> employeeData.getEmployeePesel().equals(pesel))
                .filter(employeeData -> employeeData.getYear() == (year))
                .collect(Collectors.toList());
    }

    public EmployeeData updateData(String employeeId, EmployeeData employeeData) {
        List<EmployeeData> employeeDataList = getData(employeeId);
        Optional<EmployeeData> oldData = employeeDataList.stream()
                .filter(data -> Objects.equals(data.getMonth(), employeeData.getMonth()))
                .findFirst();

        oldData.ifPresent(old -> {
            int index = employeeDataList.indexOf(old);
            employeeDataList.set(index, employeeData);
        });

        return employeeData;
    }

    public void deleteData(String employeeId) {
        employeeDataFromRepo.removeAll(getData(employeeId));
    }

    public void deleteAll(){
        this.employeeDataFromRepo.clear();
    }

    public List<EmployeeData> getAll() {
        return employeeDataFromRepo;
    }

    public int sizeData() {
        return employeeDataFromRepo.size();
    }
}