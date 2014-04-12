package org.rontai.s.authority.model;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.rontai.s.authority.domain.Role;
import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class RolePageBean implements Serializable {

	private static final long serialVersionUID = -6452553626832865436L;
	
	private List<Role> roles;



}
