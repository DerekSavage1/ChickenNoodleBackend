package online.ChewyN.ChickenNoodle.service;

import online.ChewyN.ChickenNoodle.dao.EmployeeDao;
import online.ChewyN.ChickenNoodle.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeRepo) {
        this.employeeDao = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeDao.selectAllEmployees();
    }

    public Optional<Employee> getEmployeeById(UUID id) {
        return employeeDao.selectEmployeeById(id);
    }

    public int deleteEmployeeById(UUID id) {
        return employeeDao.deleteEmployeeById(id);
    }

    public Employee updateEmployee(UUID id, Employee employee) {
        employeeDao.updateEmployee(id, employee);
        return employee;
    }

}
