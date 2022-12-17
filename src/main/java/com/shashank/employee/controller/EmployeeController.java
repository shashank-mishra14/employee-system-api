package com.shashank.employee.controller;

import com.shashank.employee.model.Employee;
import com.shashank.employee.services.EmployeeService;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/api/v1/" )
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
@PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
    return employeeService.createEmployee(employee);
}

@GetMapping("/employees")
public List<Employee> getAllEmployees(){
        return employeeService.getAllemployees();

}
}


