package org.rontai.s.menu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.rontai.s.menu.domain.MenuNode;

/**
 * Responsible for TreePanel data presentation.
 * 
 * @author glenlivet
 * 
 */
public class MenuTreePanelBean implements Serializable {

	private static final long serialVersionUID = -5502235677827248173L;

	/**
	 * menu sources
	 */
	private TreeNode resources;

	private TreeNode menubar;

	private TreeNode selectedResource;

	private TreeNode selectedMenuNode;
	
	private MenuBarPageBean pageBean;

	/**
	 * representing a new menu node
	 */
	private MenuNode current;

	public MenuTreePanelBean(MenuBarPageBean pageBean) {
		reset(pageBean.getCurrent());
		this.pageBean = pageBean;
	}

	public void reset(MenuNode node) {
		menubar = new DefaultTreeNode("menubar", null);
		resources = new DefaultTreeNode("resources", null);
		selectedResource = null;
		selectedMenuNode = null;

		new DefaultTreeNode(node, menubar);
	}

	public void saveMenu(ActionEvent event) {
		// 根节点
		TreeNode root = menubar.getChildren().get(0);
		// 处理每个节点
		handleEachNode(root);
		// 将根节点设置为头节点
		MenuNode menuRoot = (MenuNode) root.getData();
		menuRoot.setMenuBar(true);
		// 保存menunode
		pageBean.getMenuNodeService().save(menuRoot);
		// 更新pageBean
		pageBean.updateTable();
	}

	private void handleEachNode(TreeNode node) {
		int count = node.getChildCount();
		// 末节点
		if (count == 0) {
			return;
		}
		// 非根节点 将其子节点加入其上
		MenuNode menuNode = (MenuNode) node.getData();
		List<TreeNode> children = node.getChildren();
		for (TreeNode n : children) {
			MenuNode mn = (MenuNode) n.getData();
			menuNode.addSubNode(mn);
			handleEachNode(n);
		}
	}

	/**
	 * 新建一个菜单节点资源
	 * 
	 * @param event
	 */
	public void createNewResource(ActionEvent event) {
		new DefaultTreeNode(current, resources);
		current = null;
	}

	/**
	 * 初始化一个 {@link MenuNode} 作为新建的菜单节点资源
	 * 
	 * @param event
	 */
	public void beforeShowNewResourceDialog(ActionEvent event) {
		initCurrentMenuNode();
	}

	private void initCurrentMenuNode() {
		current = new MenuNode();
		current.setParent(null);
		current.setSubNodes(new ArrayList<MenuNode>());
	}

	public TreeNode getResources() {
		return resources;
	}

	public void setResources(TreeNode resources) {
		this.resources = resources;
	}

	public TreeNode getMenubar() {
		return menubar;
	}

	public void setMenubar(TreeNode menubar) {
		this.menubar = menubar;
	}

	public TreeNode getSelectedResource() {
		return selectedResource;
	}

	public void setSelectedResource(TreeNode selectedResource) {
		this.selectedResource = selectedResource;
	}

	public TreeNode getSelectedMenuNode() {
		return selectedMenuNode;
	}

	public void setSelectedMenuNode(TreeNode selectedMenuNode) {
		this.selectedMenuNode = selectedMenuNode;
	}

	public MenuNode getCurrent() {
		return current;
	}

	public void setCurrent(MenuNode current) {
		this.current = current;
	}

}
