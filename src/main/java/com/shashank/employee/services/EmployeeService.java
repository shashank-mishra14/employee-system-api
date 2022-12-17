package com.shashank.employee.services;

import com.shashank.employee.model.Employee;

import java.util.List;

public interface EmployeeService    {
    Employee createEmployee(Employee employee);

    List<Employee> getAllemployees();

    boolean deleteEmployee(Long id);
}
