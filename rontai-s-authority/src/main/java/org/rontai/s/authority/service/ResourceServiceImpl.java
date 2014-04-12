package org.rontai.s.authority.service;

import java.util.List;

import org.rontai.s.authority.domain.Resource;
import org.rontai.s.authority.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(ResourceService.SPRING_KEY)
@Repository
@Transactional
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourceRepository resourceRepository;

	@Override
	public List<Resource> findAllMenubars() {
		return resourceRepository.findAllMenubars();
	}

	public void setResourceRepository(ResourceRepository resourceRepository) {
		this.resourceRepository = resourceRepository;
	}

}
