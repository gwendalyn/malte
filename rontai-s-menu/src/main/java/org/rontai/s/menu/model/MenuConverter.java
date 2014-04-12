package org.rontai.s.menu.model;

import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import org.rontai.s.menu.domain.Menu;
import org.rontai.s.menu.service.MenuService;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class MenuConverter implements Converter {
	
	@Inject
	@Named(MenuService.SPRING_KEY)
	private MenuService menuService;

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		return menuService.findByCode(value);
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		return ((Menu)value).getCode();
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
}
