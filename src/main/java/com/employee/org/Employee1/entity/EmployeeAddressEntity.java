package com.employee.org.Employee1.entity;

import javax.persistence.*;

@Entity
public class EmployeeAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String line1;
    private String line2;
    private Long phoneNumber;
    private String city;
    private String country;
    @OneToOne(cascade = CascadeType.ALL)
    private  EmployeeDetailsEntity employeeDetails;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public EmployeeDetailsEntity getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetailsEntity employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    @Override
    public String toString() {
        return "EmployeeAddressEntity{" +
                "addressId=" + addressId +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", employeeDetails=" + employeeDetails +
                '}';
    }
}
