package com.employee.org.Employee1.repository;

import com.employee.org.Employee1.entity.EmployeeSalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepo extends JpaRepository<EmployeeSalaryEntity,Integer> {

    public List<EmployeeSalaryEntity> findByPayable(String payble);

}
