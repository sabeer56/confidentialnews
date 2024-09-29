package edu.jsp.ak.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.ak.Dao.AdminDao;
import edu.jsp.ak.Dto.AdminDetails;

@Service
public class AdminService {
	@Autowired
	public AdminDao dao;
	
	public boolean authenticateUser(String username, String password) {
        String storedPassword = dao.fetchPasswordByName(username);
        return storedPassword != null && storedPassword.equals(password);
    }
	
	public AdminDetails saveIdentity(AdminDetails i) {
		return dao.saveIdentity(i);
	}
	
	public AdminDetails fetchById(int id) {
		return dao.fetchById(id);
	}
	
	public String deleteById(int id) {
		AdminDetails i=dao.fetchById(id);
	    if(i!=null) {
	    	dao.deleteById(id);
	    	return id+" deleted";
	    }
	    return null;
	}
	public AdminDetails updateIdentity(int id,AdminDetails i) {
		AdminDetails i1=dao.fetchById(id);
		if(i1!=null) {
			i.setId(id);
			return dao.updateIdentity(i);
		}
		return null;
	}
}
