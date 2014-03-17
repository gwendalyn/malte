package org.rontai.c.test.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.rontai.c.test.domain.Contact;
import org.rontai.c.test.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

@Service("contactServiceImpl")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ContactRepository contactRepository;

	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		return Lists.newArrayList(contactRepository.findAll());
	}

	@Transactional(readOnly = true)
	public List<Contact> findAllDetails(String name) {
		return contactRepository.findAllDetails(name);
	}

	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public void save(Contact contact) {
		contactRepository.save(contact);
	}

	public List<Contact> findAllWithDetails() {
		List<Contact> contacts = em.createNamedQuery(
				"Contact.findAllWithDetail", Contact.class).getResultList();
		return contacts;
	}

}
