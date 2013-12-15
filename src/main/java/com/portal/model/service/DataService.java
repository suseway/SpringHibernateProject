package com.portal.model.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.model.dao.DataDao;
import com.portal.model.domain.Data;
 
/**
 * Data Service
 * @author lepeev.pavel
 */

@Service("dataService")
@Transactional(readOnly = false) // do not role back this transaction
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

	@Transactional(readOnly = true)
	public Data getLogin(String login, String password) {
		return dataDaoImpl.getLogin(login, password);
	}
}