package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
@Autowired
private JdbcTemplate jdbcTemplate;
// create table
    public void createTable(){
        String sql="CREATE TABLE IF NOT EXIST employees ("+
                "id INT PRIMARY KEY," +
                "name VARCHAR(50)," +
                "department  VARCHAR(50)," +
                "salary DOUBLE)";
        jdbcTemplate.execute(sql);
    }
    //insert employee
    public int addEmployee(Employee employee){
        // SQL INJECTION prevention useful -> thats why ? placeholder is used
        String sql="INSERT INTO employees(id,name,department,salary) VALUES(?,?,?,?)";
        return jdbcTemplate.update(sql,employee.getId(),
                employee.getName(),employee.getDepartment(),employee.getSalary());
    }
    // get all employees
    public List<Employee> getAllEmployees(){
        String sql="SELECT * from employees";
        return jdbcTemplate.query(sql,new EmployeeRowMapper());
    }
    // get by id
    public Employee getEmployeeById(int id){
        String sql="SELECT * from employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,new EmployeeRowMapper(),id);
    }
// update employee
    public int updateEmployee(Employee employee){
        String sql="UPDATE employees SET name=?,department=?,salary=? WHERE id =?";
        return jdbcTemplate.update(sql,employee.getName(),employee.getDepartment(),
                employee.getSalary(),employee.getId());
    }
// delete
    public int deleteEmployee(int id){
        String sql="DELETE * from employees WHERE id = ?";
        return jdbcTemplate.update(sql,id);
    }

}
