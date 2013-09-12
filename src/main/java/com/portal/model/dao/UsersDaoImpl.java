package com.portal.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.portal.model.domain.Users;

@Repository("usersDaoImpl")
@Transactional
public class UsersDaoImpl  implements UsersDao {
	
	public static Logger logger = Logger.getLogger(UsersDaoImpl.class);
	
	@Autowired
	SessionFactory sessionFactory;
    
	public void saveUsers(Users users){
		sessionFactory.getCurrentSession().save(users);
    }
	
	public void updateUsers(Users users){
    	sessionFactory.getCurrentSession().update(users);
    }
	
	public void deleteUsers(Users users){
    	sessionFactory.getCurrentSession().delete(users);
    }
	
	public void SaveOrUpdateUsers(Users users){
    	sessionFactory.getCurrentSession().saveOrUpdate(users);
    }

	@SuppressWarnings("unchecked")
	public Users getUsers(int code) {
    	return (Users) sessionFactory.getCurrentSession().get(Users.class, code);
    }

	public Users saveUserscode(Users users) {
		sessionFactory.getCurrentSession().save(users);
        return users;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true, propagation=Propagation.REQUIRED)
	 public List getAllUsers() {
		 
		 
		 /*
		  * this code doesn't work. Use code below or just add lazy="false" in Users.hbm.xml at on line 11
		  * 
		  * 
		   
		    Session session = this.sessionFactory.getCurrentSession();
			return session.createQuery("from Users").list();

		  * 
		  *   More deep explanation:
		  *   
		  *   Lazy setting decides whether to load child objects while loading the Parent Object.
		  *   You need to do this setting respective hibernate mapping file of the parent class.Lazy = true (means not to load child)
		  *   By default the lazy loading of the child objects is true.
		  *   So, if you need child accessing, set lazy="false"
		  *   
		  *   
		  *   Lazy-loading can help improve the performance significantly since often you won't need the relationship (other children) and so they will not be loaded
		  *   Lazy setting decides whether to load other objects while loading the object (FK of User table - codrol === PK of Roles table)
		  *   
		  *   
		  *   For example, in some cases you do need to load the child objects when parent is loaded.
		  *   Just make the lazy=false and hibernate will load the child when parent is loaded from the database.
		  *   
		  *   lazy="true" (by default) parent does not support child
		  *   lazy="false" support child
		  *   
		  *   
		  *	
		*/
		 
		 
		 Session session = sessionFactory.getCurrentSession();
		 
		 Query usersQuery = session.createQuery("from Users");
    
		 //empQuery.setMaxResults(maxResult);
		 List<Users> usersList = new ArrayList<Users>();
		 usersList = (List<Users>) usersQuery.list();

		 if (usersList.size() > 0)
			 for (Users u : usersList) {
				 Hibernate.initialize(u.getRoles());
			 }
	
			
			
		 //return session.createQuery("from Users").list();
		 return usersQuery.list();

		 

		 
		 
		 
	}

}
