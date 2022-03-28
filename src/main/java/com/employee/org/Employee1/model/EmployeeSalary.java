package com.employee.org.Employee1.model;

public class EmployeeSalary {
    private Integer salaryId;
    private Double salary;
    private String payable;

    public Integer getEmployeeId() {
        return salaryId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.salaryId = employeeId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPayable() {
        return payable;
    }

    public void setPayable(String payable) {
        this.payable = payable;
    }

    @Override
    public String toString() {
        return "EmployeeSalary{" +
                "employeeId=" + salaryId +
                ", salary=" + salary +
                ", payable='" + payable + '\'' +
                '}';
    }
}
