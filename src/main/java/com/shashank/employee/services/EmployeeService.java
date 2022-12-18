package com.shashank.employee.services;

import com.shashank.employee.model.Employee;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.util.List;

public interface EmployeeService    {
    Employee createEmployee(Employee employee);

    List<Employee> getAllemployees();

    boolean deleteEmployee(Long id);

    Employee getEmployeeById(SingularAttribute<AbstractPersistable, Serializable> id);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
