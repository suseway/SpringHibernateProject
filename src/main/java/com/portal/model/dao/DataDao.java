package com.portal.model.dao;

import com.portal.model.domain.Data;

/**
 * 
 * @author p.lepeev
 * "data" Table Business Object
 *
 */

public interface DataDao {

	 void saveData(Data roles); // save new user
	 
	 void deleteData(Data data); 

	 Data getLogin(String login, String password); // function for login
}
