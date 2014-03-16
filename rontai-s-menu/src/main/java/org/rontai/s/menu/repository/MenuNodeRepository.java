package org.rontai.s.menu.repository;

import java.util.List;

import org.rontai.s.menu.domain.MenuNode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MenuNodeRepository extends CrudRepository<MenuNode, Long> {
	
	@Query("select n from MenuNode n where n.headNode = true")
	public List<MenuNode> findAllHeadNode();

}
