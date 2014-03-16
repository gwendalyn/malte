package org.rontai.s.menu;

import org.rontai.s.base.SpringContext;
import org.rontai.s.menu.service.MenuNodeService;
import org.rontai.s.menu.service.MenuService;

public class MenuUtil {

	public static MenuNodeService getMenuNodeService(){
		return SpringContext.context.getBean(MenuNodeService.SPRING_KEY, MenuNodeService.class);
	}
	
	public static MenuService getMenuService(){
		return SpringContext.context.getBean(MenuService.SPRING_KEY, MenuService.class);
	}
}
