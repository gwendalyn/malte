package org.rontai.s.menu.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.rontai.s.menu.domain.Menu;
import org.rontai.s.menu.service.MenuService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class MenuPageBean implements Serializable {

	private static final long serialVersionUID = -3094847472186606739L;

	@Inject
	@Named(MenuService.SPRING_KEY)
	private MenuService menuService;

	private Menu current;

	private List<Menu> menus;

	public MenuPageBean() {

	}

	public void loadData(ComponentSystemEvent event) {
		updateTable();
	}

	private void updateTable() {
		menus = menuService.findAll();
	}

	public void doAjaxEvent(AjaxBehaviorEvent event) {
		System.out.println(current.getIsItem());
	}

	public void doShowNewEvent(ActionEvent event) {
		// 初始化表单中的current对象
		current = new Menu();
	}

	public void doSaveEvent(ActionEvent event) {
		menuService.save(current);
		current = null;
		menus = menuService.findAll();
	}

	public void doCancelEvent(ActionEvent event) {
		current = null;
	}

	public Menu getCurrent() {
		return current;
	}

	public void setCurrent(Menu current) {
		this.current = current;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

}
