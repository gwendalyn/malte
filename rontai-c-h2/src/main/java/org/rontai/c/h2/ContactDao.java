package org.rontai.c.h2;

import java.util.List;

public interface ContactDao {

	public String findFirstNameById(Long id);

	public List<Contact> findByFirstName(String firstName);

	// Find all contacts
	public List<Contact> findAll();

	// Find all contacts with telephone and hobbies
	public List<Contact> findAllWithDetail();

	// Find a contact with details by id
	public Contact findById(Long id);

	// Insert or update a contact
	public Contact save(Contact contact);

	// Delete a contact
	public void delete(Contact contact);

}
