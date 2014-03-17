package org.rontai.c.test.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "C_TEST_CONTACT")
@NamedQueries({
@NamedQuery(name="Contact.findAllWithDetail",
query="select distinct c from Contact c left join fetch c.phones t left join fetch c.hobbies h") })
public class Contact implements Serializable {

	private static final long serialVersionUID = 194088118511203783L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "C_TEST_CONTACT_HOBBY", 
	joinColumns = { @JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID") }, 
 inverseJoinColumns = { @JoinColumn(name = "HOBBY_ID", referencedColumnName = "ID") })
	private Set<Hobby> hobbies;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval= true)
	private Set<Phone> phones;
	
	public Contact(){
		
	}

	public Contact(String name) {
		this.name = name;
	}

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

	public Set<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(Set<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

}
