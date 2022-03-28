package com.employee.org.Employee1.repository;

import com.employee.org.Employee1.entity.EmployeeAttendenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendenceRepo extends JpaRepository<EmployeeAttendenceEntity,Integer> {

    public List<EmployeeAttendenceEntity> findByDateContaining(String date);

}
