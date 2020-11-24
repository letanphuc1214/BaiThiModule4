package com.codegym.ltp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employeeGroups")
public class EmployeeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmployeeGroup;
    private String EmployeeGroupName;

    @OneToMany(mappedBy = "employeeGroup")
    private Set<Employee> employees;

    public EmployeeGroup() {
    }

    public Long getIdEmployeeGroup() {
        return idEmployeeGroup;
    }

    public void setIdEmployeeGroup(Long idEmployeeGroup) {
        this.idEmployeeGroup = idEmployeeGroup;
    }

    public String getEmployeeGroupName() {
        return EmployeeGroupName;
    }

    public void setEmployeeGroupName(String employeeGroupName) {
        EmployeeGroupName = employeeGroupName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
