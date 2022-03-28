package com.employee.org.Employee1.service;

import com.employee.org.Employee1.Utility.EmployeeBasicInfo;
import com.employee.org.Employee1.Utility.EmployeeOffDays;
import com.employee.org.Employee1.entity.EmployeeAddressEntity;
import com.employee.org.Employee1.entity.EmployeeAttendenceEntity;
import com.employee.org.Employee1.entity.EmployeeDetailsEntity;
import com.employee.org.Employee1.entity.EmployeeSalaryEntity;
import com.employee.org.Employee1.model.Employee;
import com.employee.org.Employee1.model.EmployeeAddress;
import com.employee.org.Employee1.model.EmployeeAttendence;
import com.employee.org.Employee1.model.EmployeeSalary;
import com.employee.org.Employee1.repository.AddressRepo;
import com.employee.org.Employee1.repository.AttendenceRepo;
import com.employee.org.Employee1.repository.EmployeeRepository;
import com.employee.org.Employee1.repository.SalaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepo addressRepository;
     @Autowired
    private AttendenceRepo attendenceRepository;
    @Autowired
     private SalaryRepo salaryRepository;

    // Add Employee
    public void addEmpolyee(Employee employee){
        EmployeeDetailsEntity empDetails=new EmployeeDetailsEntity();
        empDetails.setName(employee.getName());
        empDetails.setEmail(employee.getEmail());
        empDetails.setEmpoyee_id(employee.getEmpoyee_id());
        //COpy Address Model Object to Address Entity Object
        EmployeeAddressEntity employeeAddressEntity=new EmployeeAddressEntity();
        employeeAddressEntity.setLine1(employee.getAddress().getLine1());
        employeeAddressEntity.setLine2(employee.getAddress().getLine2());
        employeeAddressEntity.setCity(employee.getAddress().getCity());
        employeeAddressEntity.setCountry(employee.getAddress().getCountry());
        employeeAddressEntity.setPhoneNumber(employee.getAddress().getPhoneNumber());
        employeeAddressEntity.setEmployeeDetails(empDetails);
        addressRepository.save(employeeAddressEntity);

       // Copy Attendence Model to Attendence Entity
        List<EmployeeAttendenceEntity> newAttendce= new ArrayList<>();
        employee.getAttendences().forEach(a->{
            EmployeeAttendenceEntity attendence=new EmployeeAttendenceEntity();
           // BeanUtils.copyProperties(a,attendence);
            attendence.setDate(a.getDate());
            attendence.setHoliday(a.getHoliday());
            attendence.setReasonForHoliday(a.getReasonForHoliday());
            attendence.setEmployeeDetails(empDetails);
            newAttendce.add(attendenceRepository.save(attendence));
        });
        empDetails.setAttendences(newAttendce);

// Copy Salary Model  Object to Salary Entity Object
        EmployeeSalaryEntity salary=new EmployeeSalaryEntity();
       // BeanUtils.copyProperties(employee.getSalaries(),salary) ;
        salary.setSalary(employee.getSalaries().getSalary());
        salary.setPayable(employee.getSalaries().getPayable());
        salary.setDetailsEntity(empDetails);
        salaryRepository.save(salary);
        employeeRepository.save(empDetails);
        System.out.println(employee);
    }
// GET ALL EMPLOYEES WITH COUNTRY
    public List<Employee> getAllEmployeesByCountry(String country){
// EmployeeAddressEntity
        List<EmployeeAddressEntity> addressEntity= addressRepository.findByCountry(country);
        System.out.println(addressEntity);
        List<EmployeeDetailsEntity> detailsEntities= addressEntity.stream().map(add -> add.getEmployeeDetails()).collect(Collectors.toList());

         return detailsEntities.stream().map(emp->getEmployeeModel(emp)).collect(Collectors.toList());

       }

// Get Employees Details By City
    public List<Employee> getAllEmployeesByCity(String cityA, String cityB){
        List<EmployeeAddressEntity> addressEntity  = addressRepository.findByCityOrCity(cityA,cityB);
List<EmployeeDetailsEntity> detailsEntities=addressEntity.stream().map(add -> add.getEmployeeDetails()).collect(Collectors.toList());
        return  detailsEntities.stream().map(emp->getEmployeeModel(emp)).collect(Collectors.toList());
    }

    // Get Employee by City and Country
    public List<Employee> getAllEmployeesByCityAndCountry(String city, String country){

       List<EmployeeAddressEntity> listCityAndCountry= addressRepository.findByCityAndCountry(city,country);
        List<EmployeeDetailsEntity> employeeDetailsEntities=listCityAndCountry.stream().map(add -> add.getEmployeeDetails()).collect(Collectors.toList());
        return   employeeDetailsEntities.stream().map(emp->getEmployeeModel(emp)).collect(Collectors.toList());
    }

    // Get Employee Details
public List<EmployeeBasicInfo> getAllEmployees(){
         List<EmployeeDetailsEntity> empDetails= employeeRepository.findAll();
         List<EmployeeBasicInfo> basicInfoList=new ArrayList<>();

         empDetails.stream().forEach(emp ->{

             EmployeeBasicInfo info=new EmployeeBasicInfo();
             info.setEmployeeId(emp.getEmpoyee_id());
             info.setEmpName(emp.getName());
             info.setEmpEmail(emp.getEmail());
             info.setEmpSalary(emp.getSalaries().getSalary());
             info.setPayable(emp.getSalaries().getPayable());

             basicInfoList.add(info);
         });

        return  basicInfoList;
}
// Get Employee Info based On Payable Salary
    public List<EmployeeBasicInfo> getAllEmployeesBySalaryPayble(String payble){
        List<EmployeeSalaryEntity> empSalaryList= salaryRepository.findByPayable(payble);
        List<EmployeeDetailsEntity> employeeDetailsEntities=empSalaryList.stream().map(add -> add.getDetailsEntity()).collect(Collectors.toList());
        employeeDetailsEntities.stream().map(emp->getEmployeeModel(emp)).collect(Collectors.toList());
        List<EmployeeBasicInfo> basicInfoList=new ArrayList<>();

        employeeDetailsEntities.stream().forEach(emp ->{

            EmployeeBasicInfo info=new EmployeeBasicInfo();
            info.setEmployeeId(emp.getEmpoyee_id());
            info.setEmpName(emp.getName());
            info.setEmpEmail(emp.getEmail());
            info.setEmpSalary(emp.getSalaries().getSalary());
            info.setPayable(emp.getSalaries().getPayable());

            basicInfoList.add(info);
        });
        return basicInfoList;


    }
//Get employess with Nooff Days
    public   List<EmployeeOffDays>  getNoOffDaysPerMonth(String month_Year){

        List<EmployeeAttendenceEntity> attendenceList=attendenceRepository.findByDateContaining(month_Year);

        List<EmployeeOffDays> offDaysList=new ArrayList<>();
        attendenceList.stream().forEach(emp ->{
            long noOff=attendenceList.stream().filter(attendence -> {
                return attendence.getHoliday();
            }).count();
            EmployeeOffDays info=new EmployeeOffDays();
            info.setEmployeeId(emp.getEmployeeDetails().getEmpoyee_id());
            info.setEmpName(emp.getEmployeeDetails().getName());
            info.setNoOffDay(noOff);
            info.setEmpSalary(emp.getEmployeeDetails().getSalaries().getSalary());
            offDaysList.add(info);
        });
        return offDaysList;

    }

    //Helper Mehtod
private Employee getEmployeeModel(EmployeeDetailsEntity employeeDetailsEntity){
    Employee employeeModel=new Employee();
    employeeModel.setEmpoyee_id(employeeDetailsEntity.getEmpoyee_id());
    employeeModel.setEmail(employeeDetailsEntity.getEmail());
    employeeModel.setName(employeeDetailsEntity.getName());
    // Employee Salary Entity to Model
    EmployeeSalary employeeSalaryModel=new EmployeeSalary();
    employeeSalaryModel.setSalary(employeeDetailsEntity.getSalaries().getSalary());
    employeeSalaryModel.setPayable(employeeDetailsEntity.getSalaries().getPayable());
    employeeModel.setSalaries(employeeSalaryModel);
 // EmployeeAddress Entity to Model
    EmployeeAddress addressModel=new EmployeeAddress();
    addressModel.setPhoneNumber(employeeDetailsEntity.getAddress().getPhoneNumber());
    addressModel.setLine1(employeeDetailsEntity.getAddress().getLine1());
    addressModel.setLine2(employeeDetailsEntity.getAddress().getLine2());
    addressModel.setCity(employeeDetailsEntity.getAddress().getCity());
    addressModel.setCountry(employeeDetailsEntity.getAddress().getCountry());
    employeeModel.setAddress(addressModel);
// EmployeeAttendence Entity TO Model
    List<EmployeeAttendence> attendenceModel=new ArrayList<>();
    employeeDetailsEntity.getAttendences().forEach(attendence ->{
        EmployeeAttendence attendenceModel1=new EmployeeAttendence();
       // BeanUtils.copyProperties(employeeDetailsEntity.getAttendences(),attendence);
        attendenceModel1.setHoliday(attendence.getHoliday());
        attendenceModel1.setDate(attendence.getDate());
        attendence.setReasonForHoliday(attendence.getReasonForHoliday());
        attendenceModel.add(attendenceModel1);
      });
employeeModel.setAttendences(attendenceModel);
    return employeeModel;
}
}
