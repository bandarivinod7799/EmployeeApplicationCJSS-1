package com.employee.org.Employee1;

import com.employee.org.Employee1.model.Employee;
import com.employee.org.Employee1.model.EmployeeAddress;
import com.employee.org.Employee1.model.EmployeeAttendence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class Employee1Application implements Runnable {

	public static void main(String[] args) {
		SpringApplication.run(Employee1Application.class, args);
		//EMployee 1
		Employee emp1=new Employee();
		emp1.setEmpoyee_id(101);
		emp1.setName("Vinod");
		emp1.setEmail("vinodbandari55@gmail.com");

//address
		EmployeeAddress addressEmp1=new EmployeeAddress();
		addressEmp1.setEmployeeId(101);
		addressEmp1.setLine1("madhapur-1");
		addressEmp1.setLine2("madhapur-2");
		addressEmp1.setCity("Hyderabad");
		addressEmp1.setCountry("INDIA");

// Attendece
		EmployeeAttendence employeeAttendence1=new EmployeeAttendence();
		employeeAttendence1.setEmployeeId(101);
		employeeAttendence1.setDate("1-03-2022");
		employeeAttendence1.setHoliday(false);



}
	@Override
	public void run() {

	}
}
