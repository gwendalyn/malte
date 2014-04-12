package org.rontai.s.authority.repository;

import java.util.List;

import org.rontai.s.authority.domain.Resource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource, Long> {
	
	@Query("select r from Resource r where r.type = 5")
	public List<Resource> findAllMenubars();

}
