package org.rontai.s.base.domain;

import java.io.Serializable;

public class DictItem<T> implements Serializable{
	
	private static final long serialVersionUID = 6319747506144156592L;

	public static final int EN = 0;
	
	public static final int CN = 1;

	private T value;
	
	private String label;
	
	private Dict<T> dict;
	
	private int lang = 0;
	
	private String desc;

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Dict<T> getDict() {
		return dict;
	}

	public void setDict(Dict<T> dict) {
		this.dict = dict;
	}

	public int getLang() {
		return lang;
	}

	public void setLang(int lang) {
		this.lang = lang;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
