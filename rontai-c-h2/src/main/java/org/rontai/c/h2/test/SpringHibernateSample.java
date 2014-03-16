package org.rontai.c.h2.test;

import java.util.List;
import java.util.Set;

import org.rontai.c.h2.Contact;
import org.rontai.c.h2.ContactDao;
import org.rontai.c.h2.ContactTelDetail;
import org.rontai.c.h2.ContactTelDetailDao;
import org.rontai.c.h2.Hobby;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringHibernateSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-module-context.xml");
		ctx.refresh();
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		// List<Contact> contacts;
		// contacts = contactDao.findAllWithDetail();
		// listContactsWithDetail(contacts);

		// Find contact by ID
		Contact contact;
//		contact = contactDao.findById(1l);
//		System.out.println("");
//		System.out.println("Contact with id 1:" + contact);
//		System.out.println("");

		contact = contactDao.findById(1l);
		contact.setFirstName("Kim Fung");
		Set<ContactTelDetail> contactTels = contact.getContactTelDetails();
		ContactTelDetail toDeleteContactTel = null;
		for (ContactTelDetail contactTel : contactTels) {
			if (contactTel.getTelType().equals("Home")) {
				toDeleteContactTel = contactTel;
			}
		}
		contact.removeContactTelDetail(toDeleteContactTel);
		contactDao.save(contact);
		List<Contact> contacts; 
		contacts = contactDao.findAllWithDetail();
		listContactsWithDetail(contacts);
		
		ContactTelDetailDao telDetailDao = ctx.getBean("contactTelDetailDao", ContactTelDetailDao.class);
		ContactTelDetail td = telDetailDao.findByTelNumber("2222222222");
		System.out.println(td);
	}

	private static void listContacts(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts without details:");
		for (Contact contact : contacts) {
			System.out.println(contact);
			System.out.println();
		}
	}

	private static void listContactsWithDetail(List<Contact> contacts) {
		System.out.println("");
		System.out.println("Listing contacts with details:");
		for (Contact contact : contacts) {
			System.out.println(contact);
			if (contact.getContactTelDetails() != null) {
				for (ContactTelDetail contactTelDetail : contact
						.getContactTelDetails()) {
					System.out.println(contactTelDetail);
				}
			}
			if (contact.getHobbies() != null) {
				for (Hobby hobby : contact.getHobbies()) {
					System.out.println(hobby);
				}
			}
			System.out.println();
		}
	}

}
