package com.codegym.ltp.repository;

import com.codegym.ltp.model.Employee;
import com.codegym.ltp.model.EmployeeGroup;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeGroupRepository extends PagingAndSortingRepository<EmployeeGroup, Long> {
}
