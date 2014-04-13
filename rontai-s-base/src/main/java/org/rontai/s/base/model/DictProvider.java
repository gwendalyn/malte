package org.rontai.s.base.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.rontai.s.base.domain.Dict;
import org.rontai.s.base.domain.DictDomain;
import org.rontai.s.base.domain.DictItem;
import org.rontai.s.base.service.DictDomainService;

@Named
public class DictProvider {

	private Map<String, Dict> dicts = new HashMap<String, Dict>();

	@Inject
	@Named(DictDomainService.SPRING_KEY)
	private DictDomainService dictDomainService;

	public Dict getDictByNameAndLang(String name, Integer lang) {
		Dict d = dicts.get(name + lang);
		if (d == null) {
			// fetch items from db
			d = fetchItemFromDb(name, lang);
			if(d != null)
				dicts.put(name + lang, d);
		} 
		return d;
	}

	private Dict fetchItemFromDb(String name, Integer lang) {
		List<DictDomain> dictDomains = dictDomainService.findByDictNameAndLang(
				name, lang);
		if (dictDomains.size() > 0) {
			Dict d = buildDict(dictDomains);
			return d;
		} else {
			return null;
		}
	}

	private Dict buildDict(List<DictDomain> dictDomains) {
		DictDomain dd = dictDomains.get(0);
		Dict d;
		if(dd.getValueType() == DictDomain.VALUE_TYPE_INTEGER){
			d = buildIntDict(dictDomains);
		}else {
			d = buildStringDict(dictDomains);
		}
		return d;
	}

	private Dict<String> buildStringDict(List<DictDomain> dictDomains) {
		Dict<String> d = new Dict<String>();
		d.setDesc(dictDomains.get(0).getDictDesc());
		d.setName(dictDomains.get(0).getDictName());
		List<DictItem<String>> dis = new ArrayList<DictItem<String>>();
		for(DictDomain dd : dictDomains){
			DictItem<String> di = new DictItem<String>();
			di.setDesc(dd.getItemDesc());
			di.setLabel(dd.getItemLabel());
			di.setLang(dd.getLang());
			di.setValue(dd.getItemValue());
			di.setDict(d);
			dis.add(di);
		}
		d.setItems(dis);
		return d;
	}

	private Dict<Integer> buildIntDict(List<DictDomain> dictDomains) {
		Dict<Integer> d = new Dict<Integer>();
		d.setDesc(dictDomains.get(0).getDictDesc());
		d.setName(dictDomains.get(0).getDictName());
		List<DictItem<Integer>> dis = new ArrayList<DictItem<Integer>>();
		for(DictDomain dd : dictDomains){
			DictItem<Integer> di = new DictItem<Integer>();
			di.setDesc(dd.getItemDesc());
			di.setLabel(dd.getItemLabel());
			di.setLang(dd.getLang());
			di.setValue(Integer.parseInt(dd.getItemValue()));
			di.setDict(d);
			dis.add(di);
		}
		d.setItems(dis);
		return d;
	}

}
