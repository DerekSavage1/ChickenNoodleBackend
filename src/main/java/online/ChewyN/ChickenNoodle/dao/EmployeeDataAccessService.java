package online.ChewyN.ChickenNoodle.dao;

import online.ChewyN.ChickenNoodle.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("employeepostgres")
public class EmployeeDataAccessService implements EmployeeDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee insertEmployee(UUID id, Employee employee) {
        String sql = "INSERT INTO employee(id, name, email, jobtitle, phone, imageurl) VALUES("
                + "'" + id + "', "
                + "'" +  employee.getName() + "', "
                + "'" +  employee.getEmail() + "', "
                + "'" +  employee.getJobTitle() + "', "
                + "'" +  employee.getPhone() + "', "
                + "'" +  employee.getImageUrl() + "');";


        jdbcTemplate.update(sql);


        return selectEmployeeById(id).orElse(employee);
    }

    @Override
    public List<Employee> selectAllEmployees() {
        String sql = "SELECT id, name, email, jobtitle, phone, imageurl FROM employee";
        return  jdbcTemplate.query(
                sql,
                (resultSet, i) -> {
                    UUID EmployeeId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String jobTitle = resultSet.getString("jobTitle");
                    String phone = resultSet.getString("phone");
                    String imageUrl = resultSet.getString("imageUrl");

                    return new Employee(EmployeeId, name, email, jobTitle, phone, imageUrl);
                });
    }

    @Override
    public Optional<Employee> selectEmployeeById(UUID id) {
        String sql = "SELECT id, name, email, jobtitle, phone, imageurl FROM employee WHERE id = '" + id + "';";
        Employee employee = jdbcTemplate.queryForObject(
                sql,
                (resultSet, i) -> {
                    UUID EmployeeId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String jobTitle = resultSet.getString("jobTitle");
                    String phone = resultSet.getString("phone");
                    String imageUrl = resultSet.getString("imageUrl");

                    return new Employee(EmployeeId, name, email, jobTitle, phone, imageUrl);
                });
        return Optional.ofNullable(employee);
    }

    @Override
    public int deleteEmployeeById(UUID id) {
        String sql = "DELETE FROM employee WHERE id = '" + id + "';";
        return jdbcTemplate.update(sql);
    }

    @Override
    public Employee updateEmployee(UUID id, Employee employee) {
        String sql = "UPDATE employee SET "
                + "name = '" +  employee.getName() + "', "
                + "email = '" +  employee.getEmail() + "', "
                + "jobtitle = '" +  employee.getJobTitle() + "', "
                + "phone = '" +  employee.getPhone() + "', "
                + "imageurl = '" +  employee.getImageUrl() + "'"
                + "WHERE id = '" + id + "';";

        jdbcTemplate.update(sql);
        return selectEmployeeById(id).orElse(employee); //Returns employee with null id
    }


}
