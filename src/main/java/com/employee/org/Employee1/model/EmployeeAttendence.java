package com.employee.org.Employee1.model;

public class EmployeeAttendence
{
    private Integer attendenceId;
    private String date;
    private  Boolean holiday;
    private String reasonForHoliday;


    public Integer getEmployeeId() {
        return attendenceId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.attendenceId = employeeId;
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

    @Override
    public String toString() {
        return "EmployeeAttendence{" +
                "employeeId=" + attendenceId +
                ", date='" + date + '\'' +
                ", holiday=" + holiday +
                ", reasonForHoliday='" + reasonForHoliday + '\'' +
                '}';
    }
}
