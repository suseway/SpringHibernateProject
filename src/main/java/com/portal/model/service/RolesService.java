package com.portal.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.model.dao.RolesDao;
import com.portal.model.domain.Roles;

@Service("rolesService")
@Transactional(readOnly = false) // do not role back this transaction
public class RolesService {
    
    @Autowired
    private RolesDao rolesDaoImpl;
    
    
    
	 public void saveRoles(Roles roles) {
		 rolesDaoImpl.saveRoles(roles);
	 }
	 
	 public void updateRoles(Roles roles) {
		 rolesDaoImpl.updateRoles(roles);
	 }
	 
	 public void SaveOrUpdateRoles(Roles roles) {
		 rolesDaoImpl.SaveOrUpdateRoles(roles);
	 }
	 
	 public void deleteRoles(Roles roles) {
		 rolesDaoImpl.deleteRoles(roles);
	 }
	 	 
	 public Roles saveRolescode(Roles roles) {
		 return rolesDaoImpl.saveRolescode(roles);
	 }
	 
	 @Transactional(readOnly = true)
	 public Roles getRoles(int code) {
		 return rolesDaoImpl.getRoles(code);
	 }
	
	 @Transactional(readOnly = true)
	 public List getAllRoles() {
		 return rolesDaoImpl.getAllRoles();
		 
	 }
}