package org.rontai.s.authority.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "S_AUTHORITY_ROLE")
public class Role implements Serializable{

	private static final long serialVersionUID = 4495506567756267489L;

	/**
	 * 游客
	 */
	public static final String DEFAULT_CUSTOMER_CODE = "C003";
	
	/**
	 * 管理员
	 */
	public static final String ADMIN_CODE = "A001";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CODE")
	private String code;
	
	@ManyToMany
	@JoinTable(name = "S_AUTHORITY_ROLE_RESOURCE",
	joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName="ID"),
	inverseJoinColumns = @JoinColumn(name = "RESOURCE_ID", referencedColumnName="ID"))
	private Set<Resource> resources;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
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
		if (!(obj instanceof Role))
			return false;
		Role o = (Role) obj;
		return new EqualsBuilder().append(code, o.code).isEquals();

	}

}
