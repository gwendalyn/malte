package org.rontai.s.menu.service;

import java.util.List;

import org.rontai.s.menu.domain.MenuNode;
import org.rontai.s.menu.repository.MenuNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(MenuNodeService.SPRING_KEY)
@Repository
@Transactional
public class MenuNodeServiceImpl implements MenuNodeService {
	
	@Autowired
	private MenuNodeRepository menuNodeRepository;
	
	@Transactional(readOnly = true)
	public List<MenuNode> findAllHeadNode() {
		return menuNodeRepository.findAllHeadNode();
	}

	public void save(MenuNode menuNode) {
		menuNodeRepository.save(menuNode);

	}

	public void delete(MenuNode menuNode) {
		menuNodeRepository.delete(menuNode);
	}

	public void setMenuNodeRepository(MenuNodeRepository menuNodeRepository) {
		this.menuNodeRepository = menuNodeRepository;
	}

}
