package org.rontai.c.table;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable{

	private static final long serialVersionUID = 1275951041172871392L;
	
	
	protected String test;
	protected String firstName;
	protected String lastName;
	protected Date dob;
	protected String sex;
	protected String email;
	protected String serviceLevel = "medium";
	
	public UserBean(){
		
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}
	
	public void testVali(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException{
		
	}
	
	public void doSave(ActionEvent event){
		String attr1 = (String)event.getComponent().getAttributes().get("attr1");
		Integer attrInt = Integer.parseInt(attr1);
		attrInt++;
		System.out.println(attrInt);
		System.out.println("btn clicked!");
		System.out.println("xxx");
	}

	public void validateEmail(FacesContext context, UIComponent toValidate,
			Object value) throws ValidatorException {
		String emailStr = (String) value;
		if (-1 == emailStr.indexOf("@")) {
			FacesMessage message = new FacesMessage("Invalid emailaddress");
			throw new ValidatorException(message);
		}
	}
	
	public String addConfirmedUser() {
		boolean added = true; // actual application may fail to add user
		FacesMessage doneMessage = null;
		String outcome = null;
		if (added) {
			doneMessage = new FacesMessage("Successfully added new user");
			outcome = "done";
		} else {
			doneMessage = new FacesMessage("Failed to add new user");
			outcome = "register";
		}
		FacesContext.getCurrentInstance().addMessage(null, doneMessage);
		return outcome;
	}
}
