package org.rontai.s.authority.model;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.rontai.s.authority.AuthorityUtil;
import org.rontai.s.authority.domain.User;
import org.rontai.s.authority.service.UserService;

@ManagedBean
@ViewScoped
public class UserPageBean {

	private List<User> users;
	
	private static UserService userService;
	
	public UserPageBean(){
		initService();
		users = userService.findAll();
	}

	private static synchronized void initService() {
		if(userService == null)
			userService = AuthorityUtil.getUserService();
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
