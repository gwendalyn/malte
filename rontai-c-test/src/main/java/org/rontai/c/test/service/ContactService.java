package org.rontai.c.test.service;

import java.util.List;

import org.rontai.c.test.domain.Contact;

public interface ContactService {
	
	public List<Contact> findAll();
	
	public List<Contact> findAllDetails(String name);
	
	public void save(Contact contact);
	
	public List<Contact> findAllWithDetails();

}
