package edu.jsp.ak.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.ak.Dto.AdminDetails;
import edu.jsp.ak.repo.AdminRepo;

@Repository
public class AdminDao {
	@Autowired
	public AdminRepo repo;
	
	public String fetchPasswordByName(String name) {
        return repo.fetchPasswordByName(name);
    }
	
	public AdminDetails saveIdentity(AdminDetails i) {
		return repo.save(i);
	}
	
	public AdminDetails fetchById(int id) {
	Optional<AdminDetails>	o=repo.findById(id);
	if(o.isPresent())
      return o.get();
	else
		return null;
	}
	
	public String deleteById(int id) {
		repo.deleteById(id);
		return "deleted";
	}
	
	public AdminDetails updateIdentity(AdminDetails i) {
		return repo.save(i);
	}
}
