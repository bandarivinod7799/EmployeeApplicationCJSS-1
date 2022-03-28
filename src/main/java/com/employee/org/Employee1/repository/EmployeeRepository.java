package com.employee.org.Employee1.repository;

import com.employee.org.Employee1.entity.EmployeeDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetailsEntity, Integer> {



}
