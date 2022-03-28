package com.employee.org.Employee1.repository;

import com.employee.org.Employee1.entity.EmployeeAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<EmployeeAddressEntity,Integer> {

    public List<EmployeeAddressEntity> findByCountry(String country);
    public  List<EmployeeAddressEntity> findByCityOrCity(String city1,String city2);
    public  List<EmployeeAddressEntity> findByCityAndCountry(String city,String country);
}
