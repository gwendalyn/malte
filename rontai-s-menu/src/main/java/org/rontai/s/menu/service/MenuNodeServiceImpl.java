package org.rontai.s.menu.service;

import java.util.List;

import org.rontai.s.authority.domain.Resource;
import org.rontai.s.authority.repository.ResourceRepository;
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
	
	@Autowired
	private ResourceRepository resourceRepository;
	
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

	@Override
	public List<MenuNode> findByParent(MenuNode parent) {
		return menuNodeRepository.findByParent(parent);
	}

	@Override
	public void multiSave(MenuNode menuRoot) {
		this.save(menuRoot);
		Resource r = new Resource();
		r.setCode(menuRoot.getCode());
		r.setType(Resource.TYPE_MENUBAR);
		resourceRepository.save(r);
		
	}

}
