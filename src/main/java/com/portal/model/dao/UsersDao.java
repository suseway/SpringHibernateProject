package com.portal.model.dao;
import java.util.List;

import com.portal.model.domain.Users;

public interface UsersDao {

	 void saveUsers(Users users); 			// saving new user
	 
	 void updateUsers(Users users); 		// modify user
	 
	 void SaveOrUpdateUsers(Users users); 	// save change 
	 
	 void deleteUsers(Users users); 		// delete user 
	 	 
	 Users saveUserscode(Users users); 		// store and return the object
	 
	 Users getUsers(int code); 				// return object that matches the received parameter code 
	
	 public abstract List getAllUsers();
}
