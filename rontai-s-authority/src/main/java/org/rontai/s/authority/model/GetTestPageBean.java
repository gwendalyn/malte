package org.rontai.s.authority.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@SessionScoped
public class GetTestPageBean implements Serializable {

	private static final long serialVersionUID = 1738980447909616742L;

	static Logger logger = LoggerFactory.getLogger(GetTestPageBean.class);
	
	public String getYouTested(){
		String rtn;
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		if (session == null) {
			rtn = "没有session";
		} else {
			rtn = "有session";
		}
		logger.info(rtn);
		return rtn;
	}
}
