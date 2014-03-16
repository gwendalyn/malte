package org.rontai.s.authority.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * System user domain
 * 
 * @author glenlivet
 * 
 */
@Entity
@Table(name = "S_AUTHORITY_USER")
public class User {

	/**
	 * dbId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	/**
	 * system code unique
	 */
	@Column(name = "CODE")
	private String code;

	/**
	 * display name
	 */
	@Column(name = "NICK_NAME")
	private String nickName;

	/**
	 * password of the account
	 */
	@Column(name = "PASSWORD")
	private String password;

	/**
	 * roles this user has
	 */
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ROLE_CODE", referencedColumnName="CODE")
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
		if (!(obj instanceof User))
			return false;
		User o = (User) obj;
		return new EqualsBuilder().append(code, o.code).isEquals();
	}

}
