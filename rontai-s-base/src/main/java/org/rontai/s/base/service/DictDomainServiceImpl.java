package org.rontai.s.base.service;

import java.util.List;

import org.rontai.s.base.domain.DictDomain;
import org.rontai.s.base.repository.DictDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(DictDomainService.SPRING_KEY)
@Repository
@Transactional
public class DictDomainServiceImpl implements DictDomainService {
	
	@Autowired
	private DictDomainRepository dictDomainRepository;

	@Override
	public List<DictDomain> findByDictNameAndLang(String dictName, Integer lang) {
		List<DictDomain> dicts = dictDomainRepository.findByDictNameAndLang(dictName, lang);
		return dicts;
	}

	public void setDictDomainRepository(DictDomainRepository dictDomainRepository) {
		this.dictDomainRepository = dictDomainRepository;
	}
	
}
