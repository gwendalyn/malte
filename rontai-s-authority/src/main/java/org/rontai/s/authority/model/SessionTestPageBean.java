package org.rontai.s.authority.model;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class SessionTestPageBean implements Serializable{

	private static final long serialVersionUID = 3691252206589266870L;
	
	static Logger logger = LoggerFactory.getLogger(SessionTestPageBean.class);
	
	public SessionTestPageBean() {
		logger.info("SessionTestPageBean 构造体");
		
	}
	
	public void doLogout(ActionEvent event){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) fc.getExternalContext().getRequest();
		try {
			req.logout();
			
		} catch (ServletException e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("dafff");
		logger.info("ssssssssssssssssssssss");
//		fc.getApplication().getNavigationHandler().handleNavigation(fc, null, "sessiontest?faces-redirect=true");
	}

	public String getSessionInfo() {
		String rtn;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		if(session.isNew()){
			logger.info("新的Session");
		}else {
			logger.info("旧的session");
		}
		if (session == null) {
			rtn = "没有session";
		} else {
			rtn = "有session";
		}
		logger.info(rtn);
		return rtn;
	}

}
