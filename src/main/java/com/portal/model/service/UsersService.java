package com.portal.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.model.dao.UsersDao;
import com.portal.model.domain.Users;

/**
 * Users Service
 * @author lepeev.pavel
 */

@Service("usersService")
@Transactional(readOnly = false) // do not role back this transaction
public class UsersService {
    
    @Autowired
    private UsersDao usersDaoImpl;
    
	 public void saveUsers(Users users) {
		 usersDaoImpl.saveUsers(users);
	 }
	 
	 public void updateUsers(Users users) {
		 usersDaoImpl.updateUsers(users);
	 }
	 
	 public void SaveOrUpdateUsers(Users users) {
		 usersDaoImpl.SaveOrUpdateUsers(users);
	 }
	 
	 public void deleteUsers(Users users) {
		 usersDaoImpl.deleteUsers(users);
	 }
	 	 
	 public Users saveUserscode(Users users) {
		 return usersDaoImpl.saveUserscode(users);
	 }
	 
     @Transactional(readOnly = true)
	 public Users getUsers(int code) {
		 return usersDaoImpl.getUsers(code);
	 }
	
     @Transactional(readOnly = true)
	 public List getAllUsers() {
		 return usersDaoImpl.getAllUsers();
	 }
}