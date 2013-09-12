package com.portal.model.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;





import com.portal.model.domain.Data;

@Repository("dataDaoImpl")
@Transactional
public class DataDaoImpl implements DataDao{
	
	public static Logger logger = Logger.getLogger(DataDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveData(Data data){
    	sessionFactory.getCurrentSession().save(data);
    }
	
	public void deleteData(Data data){
    	sessionFactory.getCurrentSession().delete(data);;
    }

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	public Data getLogin(String login ,String password) {
		Session session = sessionFactory.getCurrentSession();
		List list = session.createQuery("from Data where login='"+login+"' and password='"+password+"'").list();
		if (list.size() > 0) {
			return (Data) list.get(0);
		}
		return null;
	}
	
}
