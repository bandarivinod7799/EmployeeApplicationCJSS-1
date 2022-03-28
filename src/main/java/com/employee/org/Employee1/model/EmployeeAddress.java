package com.employee.org.Employee1.model;

public class EmployeeAddress {

    private Integer addId;
    private String line1;
    private String line2;
    private Long phoneNumber;
    private String city;
    private String country;

    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.addId = employeeId;
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

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "employeeId=" + addId +
                ", line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
