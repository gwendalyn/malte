package org.rontai.s.authority;

import org.rontai.s.authority.service.UserService;
import org.rontai.s.base.SpringContext;

public class AuthorityUtil {

	public static UserService getUserService(){
		return SpringContext.getApplicationContext().getBean(UserService.SPRING_KEY, UserService.class);
	}
}
