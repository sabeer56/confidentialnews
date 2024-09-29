package edu.jsp.ak.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.ak.Dto.UserDetails;
import edu.jsp.ak.repo.UserRepo;

@Repository
public class UserDao {
	@Autowired
	public UserRepo repo;
	
	public String fetchPasswordByName(String name) {
        return repo.fetchPasswordByName(name);
    }
	
	public UserDetails saveIdentity(UserDetails i) {
		return repo.save(i);
	}
	
	public UserDetails fetchById(int id) {
	Optional<UserDetails>	o=repo.findById(id);
	if(o.isPresent())
      return o.get();
	else
		return null;
	}
	
	public String deleteById(int id) {
		repo.deleteById(id);
		return "deleted";
	}
	
	public UserDetails updateIdentity(UserDetails i) {
		return repo.save(i);
	}
}
