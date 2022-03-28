package com.employee.org.Employee1.controller;

import com.employee.org.Employee1.Utility.EmployeeOffDays;
import com.employee.org.Employee1.model.Employee;
import com.employee.org.Employee1.Utility.EmployeeBasicInfo;
import com.employee.org.Employee1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeApi {

    @Autowired
    private EmployeeService service;
// Add Employee Rest End Point
    @PostMapping("/empAdd")
    public  String addEMployee(@RequestBody Employee employee){
        service.addEmpolyee(employee);
         return "Employee recorded Successfully";
    }
    // Get Employee by Country Rest End Point
    @GetMapping("/getEmpByCountry/{country}")
    public List<Employee> getAllEmployeesByCountry(@PathVariable String country){

       List<Employee> emp=service.getAllEmployeesByCountry(country);
       System.out.println(emp);
        return  emp;
    }


     // Get Employee by Cities Rest End Point
    @GetMapping("/getEmpByCity/{c1}/{c2}")
    public List<Employee> getAllEmployeesByCity(@PathVariable String c1,@PathVariable String c2){

        List<Employee> emp=service.getAllEmployeesByCity(c1,c2);
        System.out.println(emp);
        return  emp;
    }

    // get all Employess Rest End Point
    @GetMapping("/getAllEmployee")
    public List<EmployeeBasicInfo> getAllEmployees(){
List<EmployeeBasicInfo> infoList=service.getAllEmployees();

        System.out.println(infoList);
        return  infoList;
    }
    // Get payable Rest End Point
    @GetMapping("/getPayable/{payable}")
    public List<EmployeeBasicInfo>getAllEmployeesPayble(@PathVariable String payable){
        List<EmployeeBasicInfo> paybleList=service.getAllEmployeesBySalaryPayble(payable);

         System.out.println(paybleList);
        return  paybleList;
    }

    // Get Off Days End Point
    @GetMapping("/getOffDays/{Offdays}")
    public List<EmployeeOffDays> getAllEmployeesPayOff(@PathVariable String Offdays){
      List<EmployeeOffDays> offDays=service.getNoOffDaysPerMonth(Offdays);

        System.out.println(offDays);
        return offDays;
    }
}
