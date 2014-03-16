package org.rontai.s.menu.repository;

import java.util.List;

import org.rontai.s.menu.domain.Menu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long> {
	
	public List<Menu> findByCode(String code);
	
	@Query("select m from Menu m where m.code like CONCAT(?1, '%')")
	public List<Menu> findCodeStartsWith(String prefix);

}
