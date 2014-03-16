package org.rontai.s.menu.service;

import java.util.List;

import org.rontai.s.menu.domain.Menu;
import org.rontai.s.menu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service(MenuService.SPRING_KEY)
@Repository
@Transactional
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuRepository menuRepository;

	@Transactional(readOnly = true)
	public List<Menu> findAll() {
		
		return Lists.newArrayList(menuRepository.findAll());
	}

	public void save(Menu menu) {
		menuRepository.save(menu);
	}

	public void delete(Menu menu) {
		menuRepository.delete(menu);
	}

	public void setMenuRepository(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	public Menu findByCode(String code) {
		List<Menu> menus = menuRepository.findByCode(code);
		if(menus == null || menus.size() == 0){
			return null;
		}else {
			return menus.get(0);
		}
	}

	public List<Menu> findCodeStartsWith(String prefix) {
		return menuRepository.findCodeStartsWith(prefix);
	}

}
