package com.sapphire.hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name="employee")
	public class Employee {

@Id
@GeneratedValue
@Column(name="emp_id")
		private int empId;

@Column(name="name")
		private String Name;

@Column(name="dob")
		private Date DOB;

@Column(name="cnic")
		private String CNIC;

@Column(name="mobileno")
		private String mobileNo;

@Column(name="email")
		private String email;

@Column(name="password")
		private String password;
		

		public int getEmpId() {
			return empId;
		}
		
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		
		public String getName() {
			return Name;
		}
		
		public void setName(String name) {
			Name = name;
		}
		
		public Date getDOB() {
			return DOB;
		}
		
		public void setDOB(Date dOB) {
			DOB = dOB;
		}
		
		public String getCNIC() {
			return CNIC;
		}
		
		public void setCNIC(String CNIC) {
			this.CNIC = CNIC;
		}
		
		public String getMobileNo() {
			return mobileNo;
		}
		
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}

		

}
