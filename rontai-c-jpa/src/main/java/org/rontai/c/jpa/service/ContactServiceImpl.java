package org.rontai.c.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.rontai.c.jpa.domain.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

	private Log log = LogFactory.getLog(ContactServiceImpl.class);

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	public List<Contact> findAll() {
		List<Contact> contacts = em.createNamedQuery("Contact.findAll",
				Contact.class).getResultList();
		return contacts;
	}

	public List<Contact> findAllWithDetail() {
		List<Contact> contacts = em.createNamedQuery(
				"Contact.findAllWithDetail", Contact.class).getResultList();
		return contacts;
	}

	public Contact findById(Long id) {
		TypedQuery<Contact> query = em.createNamedQuery("Contact.findById",
				Contact.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public Contact save(Contact contact) {
		em.persist(contact);
		return contact;
	}

	public void delete(Contact contact) {
		// TODO Auto-generated method stub

	}
}
