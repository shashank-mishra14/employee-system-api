package com.shashank.employee.controller;

import com.shashank.employee.model.Employee;
import com.shashank.employee.services.EmployeeService;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
