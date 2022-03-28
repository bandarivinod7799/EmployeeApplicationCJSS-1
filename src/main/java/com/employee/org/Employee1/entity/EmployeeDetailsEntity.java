package com.employee.org.Employee1.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employeeDetails")
public class EmployeeDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer empoyee_id;
    private   String email;
    private String name;
    @OneToOne(mappedBy = "employeeDetails")
    private EmployeeAddressEntity address;
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employeeDetails")
    private List<EmployeeAttendenceEntity> attendences=new ArrayList<>();
    @OneToOne(mappedBy = "detailsEntity")
    private EmployeeSalaryEntity salaries;


    public Integer getEmpoyee_id() {
        return empoyee_id;
    }

    public void setEmpoyee_id(Integer empoyee_id) {
        this.empoyee_id = empoyee_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public EmployeeAddressEntity getAddress() {
        return address;
    }

    public void setAddress(EmployeeAddressEntity address) {
        this.address = address;
    }

    public List<EmployeeAttendenceEntity> getAttendences() {
        return attendences;
    }

    public void setAttendences(List<EmployeeAttendenceEntity> attendences) {
        this.attendences = attendences;
    }

    public EmployeeSalaryEntity getSalaries() {
        return salaries;
    }

    public void setSalaries(EmployeeSalaryEntity salaries) {
        this.salaries = salaries;
    }

    @Override
    public String toString() {
        return "EmployeeDetailsEntity{" +
                "empoyee_id=" + empoyee_id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", attendences=" + attendences +
                ", salaries=" + salaries +
                '}';
    }
}
