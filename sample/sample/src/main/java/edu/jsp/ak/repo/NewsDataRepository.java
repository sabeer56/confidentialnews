package edu.jsp.ak.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.ak.Dto.NewsData;

public interface NewsDataRepository extends JpaRepository<NewsData, Integer> {
}
