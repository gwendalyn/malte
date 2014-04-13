package org.rontai.s.base.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "S_DOMAIN_DICT")
public class DictDomain implements Serializable {

	private static final long serialVersionUID = 7981662854653803662L;
	
	public static final int VALUE_TYPE_INTEGER = 0;
	
	public static final int VALUE_TYPE_String = 1;
	
	/**
	 * dbId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DICT_NAME")
	private String dictName;
	
	@Column(name = "DICT_DESC")
	private String dictDesc;
	
	@Column(name = "ITEM_LABEL")
	private String itemLabel;
	
	@Column(name = "ITEM_VALUE")
	private String itemValue;
	
	@Column(name = "VALUE_TYPE")
	private Integer valueType;
	
	@Column(name = "ITEM_DESC")
	private String itemDesc;
	
	@Column(name = "LANG")
	private Integer lang;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getDictDesc() {
		return dictDesc;
	}

	public void setDictDesc(String dictDesc) {
		this.dictDesc = dictDesc;
	}

	public String getItemLabel() {
		return itemLabel;
	}

	public void setItemLabel(String itemLabel) {
		this.itemLabel = itemLabel;
	}

	public String getItemValue() {
		return itemValue;
	}

	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}

	public Integer getValueType() {
		return valueType;
	}

	public void setValueType(Integer valueType) {
		this.valueType = valueType;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Integer getLang() {
		return lang;
	}

	public void setLang(Integer lang) {
		this.lang = lang;
	}
	
}
