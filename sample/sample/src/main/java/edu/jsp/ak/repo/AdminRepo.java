package edu.jsp.ak.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.ak.Dto.AdminDetails;

public interface AdminRepo extends JpaRepository<AdminDetails, Integer> {

    // Define the query to fetch password by name
    @Query("SELECT u.password FROM AdminDetails u WHERE u.adminname = :name")
    String fetchPasswordByName(String name);
}
