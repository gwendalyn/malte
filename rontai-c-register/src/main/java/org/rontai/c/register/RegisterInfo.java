package org.rontai.c.register;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class RegisterInfo {
	
	private boolean display = false;
	
	private User currentUser;
	
	public RegisterInfo(){
		currentUser = new User();
	}
	
	public void doSave(ActionEvent event){
		display = true;
		//close dialog
		String dlgID = (String) event.getComponent().getAttributes().get("DLG_ID");
		RequestContext requestContext = RequestContext.getCurrentInstance();  
		requestContext.execute(dlgID + ".hide()");
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	public void validatePassword(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException{
		String confirm = (String) value;
		if(!currentUser.getPassword().equals(confirm)){
			FacesMessage fm = new FacesMessage("different@!");
			throw new ValidatorException(fm);
		}
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

}
