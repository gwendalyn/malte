package org.rontai.s.authority.service;

import java.util.List;

import org.rontai.s.authority.domain.Role;

public interface RoleService {
	
	public static final String SPRING_KEY = "sAuthorityRoleService";
	
	public List<Role> findAll();
	

}
