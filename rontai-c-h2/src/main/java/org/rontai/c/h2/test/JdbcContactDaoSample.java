package org.rontai.c.h2.test;

import java.util.List;

import org.rontai.c.h2.Contact;
import org.rontai.c.h2.ContactDao;
import org.springframework.context.support.GenericXmlApplicationContext;

public class JdbcContactDaoSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-module-context.xml");
		ctx.refresh();
		ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
		// Find first name by id
		// System.out.println("First name for contact id 1 is: "
		// + contactDao.findFirstNameById(1l));

		// Find contacts by first name
		List<Contact> contacts = contactDao.findByFirstName("Clarence");
		listContacts(contacts);
	}

	private static void listContacts(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}

}
