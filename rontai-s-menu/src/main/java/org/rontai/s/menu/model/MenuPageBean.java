package org.rontai.s.menu.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.context.RequestContext;
import org.rontai.s.menu.domain.Menu;
import org.rontai.s.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ManagedBean
@ViewScoped
public class MenuPageBean implements Serializable{
	
	private static final long serialVersionUID = -3094847472186606739L;

	@ManagedProperty(value="#{sMenuMenuService}")
	private MenuService menuService;
	
	private Menu current;
	
	private List<Menu> menus;
	
	public MenuPageBean() {
		
	}
	
	public void loadData(ComponentSystemEvent event){
		menus = menuService.findAll();
	}
	
	public void doAjaxEvent(AjaxBehaviorEvent event){
		System.out.println(current.getIsItem());
	}
	
	public void doShowNewEvent(ActionEvent event){
		//初始化表单中的current对象
		current = new Menu();
		//开启新增表单
		String dlgVar = (String) event.getComponent().getAttributes().get("DLG_VAR");
		RequestContext rc = RequestContext.getCurrentInstance();
		rc.execute(dlgVar + ".show()");
	}
	
	public void doSaveEvent(ActionEvent event){
		menuService.save(current);
		System.out.println("save menu success");
		
		String dlgVar = (String) event.getComponent().getAttributes().get("DLG_VAR");
		RequestContext rc = RequestContext.getCurrentInstance();
		rc.execute(dlgVar + ".hide()");
		current = null;
		
		menus = menuService.findAll();
	}
	
	public void doCancelEvent(ActionEvent event){
		String dlgVar = (String) event.getComponent().getAttributes().get("DLG_VAR");
		RequestContext rc = RequestContext.getCurrentInstance();
		rc.execute(dlgVar + ".hide()");
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
