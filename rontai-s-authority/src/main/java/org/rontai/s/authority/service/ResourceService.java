package org.rontai.s.authority.service;

import java.util.List;

import org.rontai.s.authority.domain.Resource;

public interface ResourceService {
	
	public static final String SPRING_KEY = "sAuthorityResourceService";
	
	public List<Resource> findAllMenubars();

}
