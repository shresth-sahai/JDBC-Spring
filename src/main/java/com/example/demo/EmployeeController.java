package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping("/createTable")
    public ResponseEntity<String> createTable(){
        employeeRepository.createTable();
        return ResponseEntity.ok("200 table created!");
    }
    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        employeeRepository.addEmployee(employee);
        return ResponseEntity.ok("Employee added !");
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeRepository.getEmployeeById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        employee.setId(id); employeeRepository.updateEmployee(employee);return ResponseEntity.ok("Employee updated !");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        employeeRepository.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted!");
    }

}
