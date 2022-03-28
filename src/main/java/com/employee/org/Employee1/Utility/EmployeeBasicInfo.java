package com.employee.org.Employee1.Utility;

public class EmployeeBasicInfo {

    private Integer employeeId;
    private String empName;
    private String empEmail;
    private Double empSalary;
    private String payable;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public String getPayable() {
        return payable;
    }

    public void setPayable(String payable) {
        this.payable = payable;
    }

    @Override
    public String toString() {
        return "EmployeeBasicInfo{" +
                "employeeId=" + employeeId +
                ", empName='" + empName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empSalary=" + empSalary +
                ", payable='" + payable + '\'' +
                '}';
    }
}
