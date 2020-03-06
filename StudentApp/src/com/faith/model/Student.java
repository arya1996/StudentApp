package com.faith.model;

import java.sql.Date;

public class Student {

	// instance variables
	private Integer studentId;
	private String name;
	private Date dob;
	private String email;
	private String phone;
	private Double mark;
	private Integer status;

	// Default constructor
	public Student() {
		// TODO Auto-generated constructor stub
	}

	// parameterised constructor with id
	public Student(Integer studentId, String name, Date dob, String email,
			String phone, Double mark, Integer status) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.mark = mark;
		this.status = status;
	}

	// parameterised constructor without id
	public Student(String name, Date dob, String email, String phone,
			Double mark, Integer status) {
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.mark = mark;
		this.status = status;
	}

	// Getters and Setters
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	// toString method
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", dob="
				+ dob + ", email=" + email + ", phone=" + phone + ", mark="
				+ mark + ", status=" + status + "]";
	}

}
