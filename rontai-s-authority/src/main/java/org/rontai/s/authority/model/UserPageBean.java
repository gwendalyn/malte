package org.rontai.s.authority.model;

import java.util.List;

import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.rontai.s.authority.domain.User;
import org.rontai.s.authority.service.UserService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class UserPageBean {

	private List<User> users;
	
	@Inject
	@Named(UserService.SPRING_KEY)
	private static UserService userService;
	
	public void loadDate(ComponentSystemEvent event){
		users = userService.findAll();
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public static UserService getUserService() {
		return userService;
	}

	public static void setUserService(UserService userService) {
		UserPageBean.userService = userService;
	}

}
