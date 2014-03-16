package org.rontai.c.jpa;

import java.util.List;

import org.rontai.c.jpa.domain.Contact;
import org.rontai.c.jpa.domain.ContactTelDetail;
import org.rontai.c.jpa.domain.Hobby;
import org.rontai.c.jpa.service.ContactService;
import org.rontai.c.jpa.service.ContactSummaryUntypeImpl;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JpaSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-module-context.xml");
		ctx.refresh();

		// Contact summary with untype result
//		ContactSummaryUntypeImpl contactSummaryUntype = ctx.getBean(
//				"contactSummaryUntype", ContactSummaryUntypeImpl.class);
//		contactSummaryUntype.displayAllContactSummary();

	}

	private void testListContactsWithDetail(GenericXmlApplicationContext ctx) {
		ContactService contactService = ctx.getBean("jpaContactService",
				ContactService.class);

		// List contacts without details
		// List<Contact> contacts = contactService.findAll();
		// listContacts(contacts);

		List<Contact> contacts = contactService.findAllWithDetail();
		listContactsWithDetail(contacts);
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
