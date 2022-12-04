package com.shashank.employee.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.yaml.snakeyaml.events.Event;

@Data
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;

}
