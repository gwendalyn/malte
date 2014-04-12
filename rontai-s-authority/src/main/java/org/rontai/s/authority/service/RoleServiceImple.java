package org.rontai.s.authority.service;

import java.util.List;

import org.rontai.s.authority.domain.Role;
import org.rontai.s.authority.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service(RoleService.SPRING_KEY)
@Repository
@Transactional
public class RoleServiceImple implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return Lists.newArrayList(roleRepository.findAll());
	}

	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

}
