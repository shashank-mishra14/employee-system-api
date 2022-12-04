package com.shashank.employee.services;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.shashank.employee.entity.EmployeeEntity;
import com.shashank.employee.model.Employee;
import com.shashank.employee.repository.EmployeeRepositry;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepositry employeeRepositry;

    public EmployeeServiceImpl(EmployeeRepositry employeeRepositry) {
        this.employeeRepositry = employeeRepositry;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepositry.save(employeeEntity);
        return employee;
    }
}
