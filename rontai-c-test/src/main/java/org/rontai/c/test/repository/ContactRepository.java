package org.rontai.c.test.repository;

import java.util.List;

import org.rontai.c.test.domain.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	@Query("select distinct c from Contact c left join fetch c.phones p left join fetch c.hobbies h where c.name = ?1")
	public List<Contact> findAllDetails(String name);
	
	public List<Contact> findByNameAndId(String name, Long id);

}
