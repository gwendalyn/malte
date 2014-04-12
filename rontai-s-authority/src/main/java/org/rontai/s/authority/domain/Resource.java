package org.rontai.s.authority.domain;

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
@Table(name = "S_AUTHORITY_RESOURCE")
public class Resource implements Serializable {

	private static final long serialVersionUID = 5058293948896304999L;

	public static final Integer TYPE_MENUBAR = 5;
	
	/**
	 * dbId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/**
	 * resource type
	 */
	@Column(name = "RTYPE")
	private Integer type;

	/**
	 * unique resource code for each type 
	 */
	@Column(name = "CODE")
	private String code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(type).append(code)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Resource)) {
			return false;
		}
		Resource o = (Resource) obj;
		return new EqualsBuilder().append(type, o.type).append(code, o.code)
				.isEquals();
	}

}
