package org.rontai.s.menu.service;

import java.util.List;

import org.rontai.s.menu.domain.Menu;

public interface MenuService {
	
	public static final String SPRING_KEY = "sMenuMenuService";
	
	public List<Menu> findAll();
	
	public void save(Menu menu);
	
	public void delete(Menu menu);

	public Menu findByCode(String code);
	
	public List<Menu> findCodeStartsWith(String prefix);
}
