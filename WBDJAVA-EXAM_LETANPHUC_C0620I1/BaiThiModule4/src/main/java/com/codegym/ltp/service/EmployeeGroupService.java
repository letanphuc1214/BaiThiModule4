package com.codegym.ltp.service;

import com.codegym.ltp.model.Employee;
import com.codegym.ltp.model.EmployeeGroup;

public interface EmployeeGroupService {
    Iterable<EmployeeGroup> findAll();

    EmployeeGroup findById(Long id);

    void save(Employee employee);

    void remove(Long id);
}
