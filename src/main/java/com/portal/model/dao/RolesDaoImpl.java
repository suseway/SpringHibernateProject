package com.portal.model.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.portal.model.domain.Roles;

@Repository("rolesDaoImpl")
public class RolesDaoImpl  implements RolesDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveRoles(Roles roles) {
		sessionFactory.getCurrentSession().save(roles);
    }
	
	public void updateRoles(Roles roles) {
		sessionFactory.getCurrentSession().update(roles);
    }
	
	public void deleteRoles(Roles roles) {
		sessionFactory.getCurrentSession().delete(roles);
    }
	
	public void SaveOrUpdateRoles(Roles roles){
    	sessionFactory.getCurrentSession().saveOrUpdate(roles);
    }

	public Roles getRoles(int id) {
    	return (Roles) sessionFactory.getCurrentSession().get(Roles.class, id);
    }

	public Roles saveRolescode(Roles roles) {
		sessionFactory.getCurrentSession().save(roles);
        return roles;
	}
	 
	 public List getAllRoles() {	
			return sessionFactory.getCurrentSession().createQuery("from Roles").list();
	}

}
