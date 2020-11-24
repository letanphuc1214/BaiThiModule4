package com.codegym.ltp.service.Impl;

import com.codegym.ltp.model.Employee;
import com.codegym.ltp.model.EmployeeGroup;
import com.codegym.ltp.repository.EmployeeRepository;
import com.codegym.ltp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        Employee save = employeeRepository.save(employee);
        return save;
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByFullNameContaining(String fullName, Pageable pageable) {
        return employeeRepository.findAllByFullNameContaining(fullName, pageable);
    }

    @Override
    public Iterable<Employee> findAllByEmployeeGroup(EmployeeGroup employeeGroup) {
        return null;
    }
}
