package com.yedam.employees;

import java.sql.Date;

public class Employees {
	//DTO : Data Transfer Object
	//VO : DTO + 기능
	//BEANS : DTO == VO == BEANS(web)
	
	private int employeeId; //DB의 언더바는 자바에서는 사용하지 않고 첫단어를 대문자로 바꿔서 사용
	private String lastName;
	private String email;
	private Date hireDate;
	private String jobId;
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	
	@Override
	public String toString() {
		return "Employees [employeeId=" + employeeId + ", lastName=" + lastName + ", email=" + email + ", hireDate="
				+ hireDate + ", jobId=" + jobId + "]";
	}
	
	
	
}
