package edu.jsp.ak.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.ak.Dao.UserDao;

import edu.jsp.ak.Dto.UserDetails;
import edu.jsp.ak.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	public UserDao dao;
	
	@Autowired
	public UserRepo repo;
	
	public boolean deleteUserByUsernameAndPassword(String username, String password) {
        if (repo.existsByUsernameAndPassword(username, password)) {
            repo.deleteByUsernameAndPassword(username, password);
            return true;
        }
        return false;
    }
	
	public boolean authenticateUser(String username, String password) {
        String storedPassword = dao.fetchPasswordByName(username);
        return storedPassword != null && storedPassword.equals(password);
    }
	
	public UserDetails saveIdentity(UserDetails i) {
		return dao.saveIdentity(i);
	}
	
	public UserDetails fetchById(int id) {
		return dao.fetchById(id);
	}
	
	public String deleteById(int id) {
		UserDetails i=dao.fetchById(id);
	    if(i!=null) {
	    	dao.deleteById(id);
	    	return id+" deleted";
	    }
	    return null;
	}
	public UserDetails updateIdentity(int id,UserDetails i) {
		UserDetails i1=dao.fetchById(id);
		if(i1!=null) {
			i.setId(id);
			return dao.updateIdentity(i);
		}
		return null;
	}
}
