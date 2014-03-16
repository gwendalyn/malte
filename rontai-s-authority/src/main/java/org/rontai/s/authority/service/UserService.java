package org.rontai.s.authority.service;

import java.util.List;

import org.rontai.s.authority.domain.User;

public interface UserService {
	
	public static final String SPRING_KEY = "sAuthorityUserService";

	public List<User> findAll();
	
}
