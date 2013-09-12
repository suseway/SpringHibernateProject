package com.misc.hibernate;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import com.misc.entity.Roles;
import com.misc.util.HibernateUtil;

public class BasicOperations {
	
	public static Logger logger = Logger.getLogger(BasicOperations.class);
	
	public Integer save(String name) {
		
		Integer roleId = null;
		Transaction transaction= null;
		// we have to open a new Session. If we set "hibernate.current_session_context_class" property to "thread" value, then we do not need to that.
		Session session = HibernateUtil.getSessionFactory().openSession(); 
		try {
			transaction = session.beginTransaction();
			Roles role = new Roles();
			role.setName(name);
			roleId = (Integer) session.save(role);
			transaction.commit();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.debug("error occured in save();");
		} finally {
			session.close();
			
		}
		
		return roleId;
	}
	
	public void update(Integer roleId, String name) {
		
		Transaction transaction= null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			Roles role = (Roles) session.get(Roles.class, roleId);
			role.setName(name);
			transaction.commit();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.debug("error occured in update();");
		} finally {
			session.close();
			
		}
		
	}
	
	public void delete(Integer roleId) {

		Transaction transaction= null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			Roles role = (Roles) session.get(Roles.class, roleId);
			session.delete(role);
			transaction.commit();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.debug("error occured in update();");
		} finally {
			session.close();
			
		}
		
	}
	
	public void list() {
		
		Transaction transaction= null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			List roles = session.createQuery("from Roles").list(); //session.createCriteria(Roles.class).list();
			for (Iterator iterator = roles.iterator(); iterator.hasNext();)
			{
				Roles role = (Roles) iterator.next();
				logger.debug(">> Role name : " + role.getName());
			}
			transaction.commit();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.debug("error occured in save();");
		} finally {
			session.close();
			
		}
	
	}
	
	
	public List criteriaQuery(String name) {
		
		Roles exRole = new Roles();
		exRole.setName("ivan");
		Example example = Example.create(exRole)
			.excludeZeroes()
			.ignoreCase();
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria crit = session.createCriteria(Roles.class);
		crit.add(Restrictions.eq( "name", name ));
		crit.add(Restrictions.like( "name", name.charAt(0) + "%"));
		crit.add(example);
		crit.setMaxResults(3);
		return crit.list();

		
	}
	
	public void hqlExamplelist(String ch) {
		
		Transaction transaction= null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction = session.beginTransaction();
			List roles = session.createQuery("from Roles as roles where name like ?").setString(0, "%"+ch).list();
			for (Iterator iterator = roles.iterator(); iterator.hasNext();)
			{
				Roles role = (Roles) iterator.next();
				logger.debug(">> Role name with hql: " + role.getName());
			}
			transaction.commit();
		} catch(HibernateException e) {
			transaction.rollback();
			logger.debug("error occured in save();");
		} finally {
			session.close();
			
		}
	
	}
	
	
	public static void main(String[] arg) {
		
		logger.debug("recording in DB");
		
		BasicOperations bo = new BasicOperations();
		
		
		int newId = bo.save("Ivann");
		//logger.debug("id = " + String.valueOf(newId));
		bo.list();
		bo.update(newId, "Ivan");
		
		List l = bo.criteriaQuery("Ivan");
		
		for (Iterator iterator = l.iterator(); iterator.hasNext();)
		{
			Roles role = (Roles) iterator.next();
			logger.debug("criteria name = " + role.getName());
		}
		
		bo.hqlExamplelist("n");
		
	}

}
