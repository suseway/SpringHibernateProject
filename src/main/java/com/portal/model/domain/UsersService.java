package com.portal.model.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.model.dao.UsersDao;

@Service("usersService")
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
	 
	 public Users getUsers(int code) {
		 return usersDaoImpl.getUsers(code);
	 }
	
	 public List getAllUsers() {
		 return usersDaoImpl.getAllUsers();
	 }
}