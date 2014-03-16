package org.rontai.s.menu.model;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.rontai.s.menu.MenuUtil;
import org.rontai.s.menu.domain.Menu;

@FacesConverter(value="org.rontai.s.menu.menuconverter")
public class MenuConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		
		return MenuUtil.getMenuService().findByCode(value);
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
		return ((Menu)value).getCode();
	}

}
