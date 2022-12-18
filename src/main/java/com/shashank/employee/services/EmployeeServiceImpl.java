package com.shashank.employee.services;

import com.shashank.employee.entity.EmployeeEntity;
import com.shashank.employee.model.Employee;
import com.shashank.employee.repository.EmployeeRepositry;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * @return
     */
    @Override
    public List<Employee> getAllemployees() {

        List<EmployeeEntity> employeeEntities
                =employeeRepositry.findAll();
        List<Employee> employees = employeeEntities
                .stream()
                .map(emp-> new Employee(emp.getId()
                , emp.getFirstName(), emp.getLastName(), emp.getEmailId()))
                .collect(Collectors.toList());
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepositry.findById(id).get();
        employeeRepositry.delete(employee);
        return true;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Employee getEmployeeById(SingularAttribute<AbstractPersistable, Serializable> id) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity= employeeRepositry.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee );
        return employee;
    }

    /**
     * @param id
     * @param employee
     * @return
     */
    @Override
    public Employee updateEmployee(Long id, Employee employee) {
       EmployeeEntity employeeEntity= employeeRepositry.findById(id).get();
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName((employee.getFirstName()));
        employeeEntity.setLastName(employeeEntity.getLastName());
        employeeRepositry.save(employeeEntity);

        return employee;
    }
}
