package com.sapphire.semmanagedbean;


import java.io.File;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sapphire.hibernate.Employee;
import com.sapphire.hibernate.EmployeeDAO;
import com.sapphire.sem.GenerateEmail;
import com.sapphire.sem.ValidatorClass;


@SessionScoped
@ManagedBean(name="indexManagedBean")
public class IndexManagedBean {
	
	public  String fullname;
	public  Date dob;
	public  String cnic;
	public  String mobilenum;
	public  String email;
	public  String password;
	public  String confirmpassword;
	public 	File file;
	public  String loginemail;
	public  String loginpassword;
	public 	String emailVarificationCode;
	public 	String emailCode;
	public 	String SMSCode;
	private String OriginalEmailCode=null;
	private String SMSVerificationCode=null;
	private String emailcode;
	boolean emailCodeIsValid=false;
	

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getCnic() {
		return cnic;
	}


	public void setCnic(String cnic) {
		this.cnic = cnic;
	}


	public String getMobilenum() {
		return mobilenum;
	}


	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
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


	public String getConfirmpassword() {
		return confirmpassword;
	}


	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getLoginemail() {
		return loginemail;
	}


	public void setLoginemail(String loginemail) {
		this.loginemail = loginemail;
	}


	public String getLoginpassword() {
		return loginpassword;
	}


	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}


	public String getEmailVarificationCode() {
		return emailVarificationCode;
	}


	public void setEmailVarificationCode(String emailVarificationCode) {
		this.emailVarificationCode = emailVarificationCode;
	}


	public String getEmailCode() {
		return emailCode;
	}


	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}


	public String getSMSCode() {
		return SMSCode;
	}


	public void setSMSCode(String sMSCode) {
		SMSCode = sMSCode;
	}


	public String getOriginalEmailCode() {
		return OriginalEmailCode;
	}


	public String getEmailcode() {
		return emailcode;
	}


	public void setEmailcode(String emailcode) {
		this.emailcode = emailcode;
	}


	public boolean getEmailCodeIsValid() {
		return emailCodeIsValid;
	}


	public void setEmailCodeIsValid(boolean emailCodeIsValid) {
		this.emailCodeIsValid = emailCodeIsValid;
	}


	public void setOriginalEmailCode(
			String OriginalEmailCode) {
		this.OriginalEmailCode = OriginalEmailCode;
	}


	public String getSMSVerificationCode() {
		return SMSVerificationCode;
	}


	public void setSMSVerificationCode(String sMSVerificationCode) {
		SMSVerificationCode = sMSVerificationCode;
	}


	//Business Logic methods
	
			public String signUp(){
				
					System.out.println(" before assigning variables");
					
					Employee employee=new Employee();
					
					employee.setName(this.fullname);
					employee.setCNIC(this.cnic);
					employee.setDOB(this.dob);
					employee.setEmail(this.email);
					employee.setMobileNo(this.mobilenum);
					employee.setPassword(this.password);
					
					System.out.println(" after assigning variables");
				
					EmployeeDAO employeeDAO=new EmployeeDAO();
					
					System.out.println(" after creating DAO Object");
					
					employeeDAO.addEmployee(employee);
					
					System.out.println(" after adding record");
					
					return "success";
			}
				
			public boolean validateCodeViaEmail(){
			
				//setOriginalEmailCode(this.emailVarificationCode);
				
				//System.out.println("SignupValidationManagedBean emailcode:" + getOriginalEmailCode());
				System.out.println("Inside Validate Code Via Email");
				
				if(emailCode==null){
					System.out.println("Inside Validate Code Via Email: null");
					
				}
				
				else if(emailCode!=null && emailCode.equals(OriginalEmailCode)){
					System.out.println("Inside Validate Code Via Email:valid code");
					
					setEmailCodeIsValid(true);
					
				}
				
				else {
					setEmailCodeIsValid(false);
					System.out.println("Inside Validate Code Via Email:invalid code"+getEmailCodeIsValid());
					
					 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "invalid code"));
					 
				}
				return getEmailCodeIsValid();
			}
			
			public void login(){
			}
	
			
			public void sendEmailcode(){
					if(email==null){
						
					}
					float code=(float)Math.random()*1000000;
					OriginalEmailCode=Integer.toString((int)code);
					System.out.println(OriginalEmailCode);
					
				emailVarificationCode=GenerateEmail.sendEmail(getEmail(),OriginalEmailCode);
			}
			
			public void comparePassword(){
				
			}
	}

