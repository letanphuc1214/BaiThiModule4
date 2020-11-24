package com.codegym.ltp.repository;

import com.codegym.ltp.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Page<Employee> findAllByFullNameContaining(String fullName, Pageable pageable);
}
