package org.rontai.s.base.service;

import java.util.List;

import org.rontai.s.base.domain.DictDomain;

public interface DictDomainService {
	
	public static final String SPRING_KEY = "sBaseDictDomainService";
	
	public List<DictDomain> findByDictNameAndLang(String dictName, Integer lang);
}
