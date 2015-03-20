package com.sapphire.semmanagedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class SignupValidationManagedBean {
	
	String emailCode;
	String SMSCode;
	
	String OriginalemailVerificationCode=null;
	String SMSVerificationCode=null;
	String to=null;
	
	public String getEmailCode() {
		return emailCode;
	}
	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}
	public String getSMSCode() {
		return SMSCode;
	}
	public void setSMSCode(String SMSCode) {
		this.SMSCode = SMSCode;
	}
	
	public String getOriginalemailVerificationCode() {
		return OriginalemailVerificationCode;
	}
	public void setOriginalemailVerificationCode(
			String originalemailVerificationCode) {
		OriginalemailVerificationCode = originalemailVerificationCode;
	}
	public String getSMSVerificationCode() {
		return SMSVerificationCode;
	}
	public void setSMSVerificationCode(String sMSVerificationCode) {
		SMSVerificationCode = sMSVerificationCode;
	}
	
	public String validateCodeViaEmail(){
		IndexManagedBean bean=new IndexManagedBean();
		setOriginalemailVerificationCode(bean.emailVarificationCode);
		setTo(bean.getEmail());
		System.out.println("SignupValidationManagedBean emailcode:" + getOriginalemailVerificationCode());
		
		if(emailCode.equals(OriginalemailVerificationCode) || to.equals(anObject)){
			
		}
		else {
			 FacesContext.getCurrentInstance().addMessage(null,
		                new FacesMessage("Incorrect Code!"));
			
		}
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public void validateCodeViaSMS(){
		
	}
	
	
}
