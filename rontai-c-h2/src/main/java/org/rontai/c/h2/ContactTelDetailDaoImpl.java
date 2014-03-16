package org.rontai.c.h2;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("contactTelDetailDao")
@Transactional
public class ContactTelDetailDaoImpl implements ContactTelDetailDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	public ContactTelDetail findByTelNumber(String telNumber) {
		return (ContactTelDetail) sessionFactory.getCurrentSession()
				.getNamedQuery("ContactTelDetail.findByTelNumber")
				.setParameter("telNumber", telNumber).uniqueResult();
	}

}
