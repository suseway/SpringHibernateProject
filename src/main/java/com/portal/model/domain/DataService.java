package com.portal.model.domain;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.model.dao.DataDao;
 
@Service("dataService")
public class DataService {
	
	public static Logger logger = Logger.getLogger(DataService.class);
    
    @Autowired
    private DataDao dataDaoImpl;
    
    public void saveData(Data roles) {
    	dataDaoImpl.saveData(roles);
    }
	 
	public void deleteData(Data data) {
		dataDaoImpl.deleteData(data);
	}

	public Data getLogin(String login, String password) {
		return dataDaoImpl.getLogin(login, password);
	}
}