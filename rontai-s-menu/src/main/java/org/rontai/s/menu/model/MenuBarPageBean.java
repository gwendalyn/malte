package org.rontai.s.menu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.rontai.s.menu.domain.Menu;
import org.rontai.s.menu.domain.MenuNode;
import org.rontai.s.menu.service.MenuNodeService;
import org.rontai.s.menu.service.MenuService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class MenuBarPageBean implements Serializable {

	private static final long serialVersionUID = -6420095504852247002L;

	@Inject
	@Named(MenuService.SPRING_KEY)
	private MenuService menuService;
	
	@Inject
	@Named(MenuNodeService.SPRING_KEY)
	private MenuNodeService menuNodeService;
	
	private List<MenuNode> menuNodes;
	
	private MenuTreePanelBean treePanel;
	
	private MenuNode current;
	
	private MenuNode selected;
	
	public void loadData(ComponentSystemEvent event) {
		updateTable();
	}

	public void updateTable() {
		menuNodes = menuNodeService.findAllHeadNode();
	}
	
	public void beforeShowCreateNewRootDlg(ActionEvent event) {
		initCurrent();
	}

	private void initCurrent() {
		current = new MenuNode();
		current.setMenuBar(true);
		current.setParent(null);
		current.setSubNodes(new ArrayList<MenuNode>());
	}
	
	public List<Menu> completeMenu(String query) {
		return menuService.findCodeStartsWith(query);
	}
	
	public void beforeShowTreePanel(ActionEvent event) {
		treePanel = new MenuTreePanelBean(this);
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public MenuNodeService getMenuNodeService() {
		return menuNodeService;
	}

	public void setMenuNodeService(MenuNodeService menuNodeService) {
		this.menuNodeService = menuNodeService;
	}

	public List<MenuNode> getMenuNodes() {
		return menuNodes;
	}

	public void setMenuNodes(List<MenuNode> menuNodes) {
		this.menuNodes = menuNodes;
	}

	public MenuTreePanelBean getTreePanel() {
		return treePanel;
	}

	public void setTreePanel(MenuTreePanelBean treePanel) {
		this.treePanel = treePanel;
	}

	public MenuNode getCurrent() {
		return current;
	}

	public void setCurrent(MenuNode current) {
		this.current = current;
	}

	public MenuNode getSelected() {
		return selected;
	}

	public void setSelected(MenuNode selected) {
		this.selected = selected;
	}

}
