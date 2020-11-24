package com.codegym.ltp.service;

import com.codegym.ltp.model.Employee;
import com.codegym.ltp.model.EmployeeGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Iterable<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void remove(Long id);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByFullNameContaining(String fullName, Pageable pageable);


    Iterable<Employee> findAllByEmployeeGroup(EmployeeGroup employeeGroup);
}
