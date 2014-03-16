package org.rontai.c.register;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DataList {
	
	private static List<Info> infos;
	
	static{
		infos = new ArrayList<Info>();
		infos.add(new Info("name1", "AAAAAAAAAAAAAAAAAAAAAAAAAA"));
		infos.add(new Info("name2", "BBBBBBBBBBBBBBBBBBBBBBBBBBB"));
	}

	public List<Info> getInfos() {
		return infos;
	}

	public void setInfos(List<Info> infos) {
		this.infos = infos;
	}
	
	

}
