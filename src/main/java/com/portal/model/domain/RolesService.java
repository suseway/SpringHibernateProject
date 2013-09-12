package com.portal.model.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.model.dao.RolesDao;

@Service("rolesService")
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
	 
	 public Roles getRoles(int code) {
		 return rolesDaoImpl.getRoles(code);
	 }
	
	 public List getAllRoles() {
		 return rolesDaoImpl.getAllRoles();
		 
	 }
}