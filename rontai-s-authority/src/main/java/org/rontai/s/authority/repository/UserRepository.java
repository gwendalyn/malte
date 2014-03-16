package org.rontai.s.authority.repository;

import org.rontai.s.authority.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
