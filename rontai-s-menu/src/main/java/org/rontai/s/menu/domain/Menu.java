package org.rontai.s.menu.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 
 * 
 * @author glenlivet
 * 
 */
@Entity
@Table(name = "S_MENU_MENU")
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5649855704981753394L;

	/**
	 * DB ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CODE")
	private String code;

	/**
	 * menu label
	 */
	@Column(name = "LABEL")
	private String label;

	/**
	 * menu icon
	 */
	@Column(name = "ICON")
	private String icon;

	/**
	 * menu outcome
	 */
	@Column(name = "OUTCOME")
	private String outcome;

	/**
	 * is menu item
	 */
	@Column(name = "IS_ITEM")
	private Boolean isItem = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getOutcome() {
		return outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public Boolean getIsItem() {
		return isItem;
	}

	public void setIsItem(Boolean isItem) {
		this.isItem = isItem;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(code).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Menu)) {
			return false;
		}
		Menu o = (Menu) obj;
		return new EqualsBuilder().append(code, o.code).isEquals();
	}

	@Override
	public String toString() {
		return this.getLabel();
	}

}
