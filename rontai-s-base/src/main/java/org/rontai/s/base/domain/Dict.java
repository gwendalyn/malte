package org.rontai.s.base.domain;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Dict<T> implements Serializable {

	private static final long serialVersionUID = 1559118169757773395L;

	private String name;

	private String desc;

	private List<DictItem<T>> Items;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<DictItem<T>> getItems() {
		return Items;
	}

	public void setItems(List<DictItem<T>> items) {
		Items = items;
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder(17, 31).append(name).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Dict)) {
			return false;
		}
		Dict d = (Dict) obj;
		return new EqualsBuilder().append(name, d.getName()).isEquals();
	}

}
