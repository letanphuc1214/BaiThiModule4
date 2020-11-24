package com.codegym.ltp.service.Impl;

import com.codegym.ltp.model.Employee;
import com.codegym.ltp.model.EmployeeGroup;
import com.codegym.ltp.repository.EmployeeGroupRepository;
import com.codegym.ltp.service.EmployeeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeGroupServiceImpl implements EmployeeGroupService {
    @Autowired
    private EmployeeGroupRepository employeeGroupRepository;

    @Override
    public Iterable<EmployeeGroup> findAll() {
        return employeeGroupRepository.findAll();
    }

    @Override
    public EmployeeGroup findById(Long id) {
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void remove(Long id) {

    }
}
