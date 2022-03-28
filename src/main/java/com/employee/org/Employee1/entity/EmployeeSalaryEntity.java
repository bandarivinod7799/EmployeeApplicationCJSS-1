package com.employee.org.Employee1.entity;

import javax.persistence.*;

@Entity
public class EmployeeSalaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salaryId;
    private Double salary;
    private String payable;
    @OneToOne(cascade = CascadeType.ALL)
private EmployeeDetailsEntity detailsEntity;

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
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

    public EmployeeDetailsEntity getDetailsEntity() {
        return detailsEntity;
    }

    public void setDetailsEntity(EmployeeDetailsEntity detailsEntity) {
        this.detailsEntity = detailsEntity;
    }

    @Override
    public String toString() {
        return "EmployeeSalaryEntity{" +
                "salaryId=" + salaryId +
                ", salary=" + salary +
                ", payable='" + payable + '\'' +
                ", detailsEntity=" + detailsEntity +
                '}';
    }
}
