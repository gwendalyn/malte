package org.rontai.s.menu.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.rontai.s.menu.MenuUtil;
import org.rontai.s.menu.domain.Menu;
import org.rontai.s.menu.domain.MenuNode;
import org.rontai.s.menu.service.MenuNodeService;
import org.rontai.s.menu.service.MenuService;

@ManagedBean
@ViewScoped
public class MenuTreePageBean implements Serializable {

	private static final long serialVersionUID = 6489761962473528462L;
	
	private static MenuNodeService menuNodeService;
	
	private static MenuService menuService;
	
	private List<MenuNode> menuNodes;
	
	private MenuNode current;
	
	private TreeNode currentRoot;

	public MenuTreePageBean(){
		initService();
		menuNodes = menuNodeService.findAllHeadNode();
	}
	
	public List<Menu> completeMenu(String query){
		return menuService.findCodeStartsWith(query);
	}
	
	public void doSaveHeadMenuEvent(ActionEvent event){
		menuNodeService.save(current);
		
		String dlgVar = (String) event.getComponent().getAttributes().get("DLG_VAR");
		RequestContext rc = RequestContext.getCurrentInstance();
		rc.execute(dlgVar + ".hide()");
		current = null;
		
		menuNodes = menuNodeService.findAllHeadNode();
	}
	
	
	public void doShowNewEvent(ActionEvent event){
		//初始化表单中的current对象
		initCurrent();
//		initCurrentTreeRoot();
		//开启新增表单
		String dlgVar = (String) event.getComponent().getAttributes().get("DLG_VAR");
		RequestContext rc = RequestContext.getCurrentInstance();
		rc.execute(dlgVar + ".show()");
	}

	private void initCurrent() {
		current = new MenuNode();
		current.setHeadNode(true);
		current.setBtmNode(false);
		current.setParent(null);
		current.setSubNodes(new ArrayList<MenuNode>());
	}

	private void initCurrentTreeRoot() {
		currentRoot = new DefaultTreeNode("Root", null);
		TreeNode node = new DefaultTreeNode(current, currentRoot);
	}

	private static synchronized void initService() {
		if(menuService == null)
			menuService = MenuUtil.getMenuService();
		if(menuNodeService == null)
			menuNodeService = MenuUtil.getMenuNodeService();
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
	
}
