package org.rontai.s.base;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

@ManagedBean
@SessionScoped
public class MenuProvider {

	private MenuModel menuModel;

	public MenuProvider() {
		menuModel = new DefaultMenuModel();
		
		addSubMenus("testMenu1", new String[]{"menuItem1"});

		addSubMenus("testMenu2", new String[]{"menuItem2", "menuItem3"});

	}

	private void addSubMenus(String label, String[] values) {
		Submenu sm = new Submenu();
		sm.setLabel(label);
		for (String v : values) {
			addMenuItems(sm, v);
			menuModel.addSubmenu(sm);
		}
	}

	private void addMenuItems(Submenu sm, String value) {
		MenuItem item = new MenuItem();
		item.setValue(value);
		item.setOutcome("");
		sm.getChildren().add(item);
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

}
