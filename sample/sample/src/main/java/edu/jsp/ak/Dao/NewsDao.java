package edu.jsp.ak.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.ak.Dto.NewsData;
import edu.jsp.ak.repo.NewsDataRepository;

@Repository
public class NewsDao {
	@Autowired
	public NewsDataRepository repo;
	
	public NewsData saveData(NewsData i) {
		return repo.save(i);
	}
	
	public NewsData fetchById(int id) {
	Optional<NewsData>	o=repo.findById(id);
	if(o.isPresent())
      return o.get();
	else
		return null;
	}
	
	public String deleteById(int id) {
		repo.deleteById(id);
		return "deleted";
	}
	
	public NewsData updateData(NewsData i) {
		return repo.save(i);
	}
}