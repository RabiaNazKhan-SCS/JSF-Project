package com.sapphire.sem;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.validator.FacesValidator;

import com.sapphire.semmanagedbean.IndexManagedBean;

@FacesValidator("com.sapphire.sem.ValidatorClass")
public class ValidatorClass implements Validator{
	IndexManagedBean bean=new IndexManagedBean();
	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object object)
			throws ValidatorException {
		
		try{
		if(bean.getPassword().equals(bean.getConfirmpassword())){
			System.out.println("confirm");
		}
		else{
			System.out.println("mismatch");
		}
		}catch(ValidatorException e){
			FacesMessage msg =
		            new FacesMessage("Password validation failed","Password Mismatch!");
		         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		         throw new ValidatorException(msg);
			
		}
	}

}
