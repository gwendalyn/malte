package org.rontai.c.jpa.service;

import java.util.List;

import org.rontai.c.jpa.domain.Contact;

public interface ContactService {
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
