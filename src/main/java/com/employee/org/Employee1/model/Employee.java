package com.employee.org.Employee1.model;

import java.util.List;

public class Employee {

    private  Integer empoyee_id;
    private   String email;
    private String name;
    private EmployeeAddress address;
    private List<EmployeeAttendence> attendences;
    private  EmployeeSalary salaries;

    public EmployeeAddress getAddress() {
        return address;
    }

    public void setAddress(EmployeeAddress address) {
        this.address = address;
    }

    public List<EmployeeAttendence> getAttendences() {
        return attendences;
    }

    public void setAttendences(List<EmployeeAttendence> attendences) {
        this.attendences = attendences;
    }

    public EmployeeSalary getSalaries() {
        return salaries;
    }

    public void setSalaries(EmployeeSalary salaries) {
        this.salaries = salaries;
    }



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

    @Override
    public String toString() {
        return "Employee{" +
                "empoyee_id=" + empoyee_id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", attendences=" + attendences +
                ", salaries=" + salaries +
                '}';
    }
}
