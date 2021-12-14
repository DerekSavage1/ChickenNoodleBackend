package online.ChewyN.ChickenNoodle.dao;

import online.ChewyN.ChickenNoodle.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeDao {

    Employee insertEmployee(UUID id, Employee employee);

    default Employee insertEmployee(Employee employee) {
        UUID id = UUID.randomUUID();
        return insertEmployee(id, employee);
    }

    List<Employee> selectAllEmployees();

    Optional<Employee> selectEmployeeById(UUID id);

    int deleteEmployeeById(UUID id);

    Employee updateEmployee(UUID id, Employee employee);
}
