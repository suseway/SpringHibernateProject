package com.portal.model.dao;

import java.util.List;
import com.portal.model.domain.Roles;

/**
 * 
 * @author p.lepeev
 * "roles" Table Business Object
 *
 */

public interface RolesDao {

	 void saveRoles(Roles roles); 			// save new role
	 
	 void updateRoles(Roles roles); 		// modify role
	 
	 void SaveOrUpdateRoles(Roles roles); 	// save or modify 
	 
	 void deleteRoles(Roles roles); 		// delete 
	 	 
	 Roles saveRolescode(Roles roles);		// store and returns the object
	 
	 Roles getRoles(int code); 				// return san object that matches code 
	
	 public abstract List getAllRoles();
}
