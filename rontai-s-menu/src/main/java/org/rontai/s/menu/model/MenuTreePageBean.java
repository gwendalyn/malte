package org.rontai.s.menu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.model.TreeNode;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.rontai.s.menu.domain.Menu;
import org.rontai.s.menu.domain.MenuNode;
import org.rontai.s.menu.service.MenuNodeService;
import org.rontai.s.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
@ViewScoped
public class MenuTreePageBean implements Serializable {

	private static final long serialVersionUID = 6489761962473528462L;

	@ManagedProperty(value="#{sMenuMenuNodeService}")
	private MenuNodeService menuNodeService;

	@ManagedProperty(value="#{sMenuMenuService}")
	private MenuService menuService;

	private List<MenuNode> menuNodes;

	private MenuNode current;

	private MenuNode selected;
	
	private MenuNode first;

	private TreeNode currentRoot;

	private MenuNode child;

	private MenuNode parent;

	private MenuTreePanelBean treePanel;

	private MenuModel menubarModel;

	public MenuTreePageBean() {
		
	}
	
	public void loadData(ComponentSystemEvent event){
		updateTable();
		first = menuNodes.get(0);
		initMenuModel();
	}

	public void updateTable() {
		menuNodes = menuNodeService.findAllHeadNode();
	}

	public void beforeDisplayMenu(ActionEvent event) {
		if (selected == null) {
			return;
		}
		initMenuModel();
	}

	private void initMenuModel() {
		menubarModel = new DefaultMenuModel();
		List<MenuNode> nodes = menuNodeService.findByParent(first);
		for (MenuNode n : nodes) {
			Menu m = n.getMenu();
			if (m.getIsItem()) {
				DefaultMenuItem item = new DefaultMenuItem(m.getLabel());
				item.setOutcome(m.getOutcome());
				String icon = m.getIcon();
				if (icon != null && !icon.isEmpty())
					item.setIcon(icon);
				menubarModel.addElement(item);
			} else {
				DefaultSubMenu sm = new DefaultSubMenu(m.getLabel());
				menubarModel.addElement(sm);
				handleSubMenu(sm, n);
			}
		}
	}

	private void handleSubMenu(DefaultSubMenu sm, MenuNode subNode) {
		List<MenuNode> nodes = menuNodeService.findByParent(subNode);
		for(MenuNode n : nodes){
			Menu m = n.getMenu();
			if(m.getIsItem()){
				DefaultMenuItem item = new DefaultMenuItem(m.getLabel());
				item.setOutcome(m.getOutcome());
				String icon = m.getIcon();
				if (icon != null && !icon.isEmpty())
					item.setIcon(icon);
				sm.addElement(item);
			}else {
				DefaultSubMenu dsm = new DefaultSubMenu(m.getLabel());
				sm.addElement(dsm);
				handleSubMenu(dsm, n);
			}
		}
	}

	public List<Menu> completeMenu(String query) {
		return menuService.findCodeStartsWith(query);
	}

	public void beforeShowTreePanel(ActionEvent event) {
		treePanel = new MenuTreePanelBean(this);
	}

	public void doShowNewEvent(ActionEvent event) {
		// 初始化表单中的current对象
		initCurrent();
	}

	private void initCurrent() {
		current = new MenuNode();
		current.setHeadNode(true);
		current.setBtmNode(false);
		current.setParent(null);
		current.setSubNodes(new ArrayList<MenuNode>());
	}

	public List<MenuNode> getMenuNodes() {
		return menuNodes;
	}

	public void setMenuNodes(List<MenuNode> menuNodes) {
		this.menuNodes = menuNodes;
	}

	public MenuNode getCurrent() {
		return current;
	}

	public void setCurrent(MenuNode current) {
		this.current = current;
	}

	public TreeNode getCurrentRoot() {
		return currentRoot;
	}

	public MenuNode getChild() {
		return child;
	}

	public void setChild(MenuNode child) {
		this.child = child;
	}

	public MenuNode getParent() {
		return parent;
	}

	public void setParent(MenuNode parent) {
		this.parent = parent;
	}

	public void setCurrentRoot(TreeNode currentRoot) {
		this.currentRoot = currentRoot;
	}

	public MenuTreePanelBean getTreePanel() {
		return treePanel;
	}

	public void setTreePanel(MenuTreePanelBean treePanel) {
		this.treePanel = treePanel;
	}

	public MenuNodeService getMenuNodeService() {
		return menuNodeService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public void setMenuNodeService(MenuNodeService menuNodeService) {
		this.menuNodeService = menuNodeService;
	}

	public MenuNode getSelected() {
		return selected;
	}

	public void setSelected(MenuNode selected) {
		this.selected = selected;
	}

	public MenuModel getMenubarModel() {
		return menubarModel;
	}

}
