package org.rontai.s.base.repository;

import java.util.List;

import org.rontai.s.base.domain.DictDomain;
import org.springframework.data.repository.Repository;

public interface DictDomainRepository extends Repository<DictDomain, Long> {
	
	public List<DictDomain> findByDictNameAndLang(String dictName, Integer lang);
}
