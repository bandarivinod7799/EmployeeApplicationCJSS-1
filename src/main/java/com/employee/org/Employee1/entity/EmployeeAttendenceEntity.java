package com.employee.org.Employee1.entity;

import javax.persistence.*;

@Entity
public class EmployeeAttendenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendeceId;
    private String date;
    private  Boolean holiday;
    private String reasonForHoliday;
    @ManyToOne
    private EmployeeDetailsEntity employeeDetails;


    public Integer getEmployeeId() {
        return attendeceId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.attendeceId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getHoliday() {
        return holiday;
    }

    public void setHoliday(Boolean holiday) {
        this.holiday = holiday;
    }

    public String getReasonForHoliday() {
        return reasonForHoliday;
    }

    public void setReasonForHoliday(String reasonForHoliday) {
        this.reasonForHoliday = reasonForHoliday;
    }
    public EmployeeDetailsEntity getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetailsEntity employeeDetails) {
        this.employeeDetails = employeeDetails;
    }
    @Override
    public String toString() {
        return "EmployeeAttendence{" +
                "employeeId=" + attendeceId +
                ", date='" + date + '\'' +
                ", holiday=" + holiday +
                ", reasonForHoliday='" + reasonForHoliday + '\'' +
                '}';
    }
}
