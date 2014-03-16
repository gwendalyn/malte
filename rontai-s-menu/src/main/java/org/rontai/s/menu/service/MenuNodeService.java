package org.rontai.s.menu.service;

import java.util.List;

import org.rontai.s.menu.domain.MenuNode;

public interface MenuNodeService {
	
	public static final String SPRING_KEY = "sMenuMenuNodeService";
	
	public List<MenuNode> findAllHeadNode();
	
	public void save(MenuNode menuNode);
	
	public void delete(MenuNode menuNode);

}
