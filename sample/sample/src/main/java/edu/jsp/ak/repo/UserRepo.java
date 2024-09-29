package edu.jsp.ak.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.jsp.ak.Dto.UserDetails;
import jakarta.transaction.Transactional;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {

    // Define the query to fetch password by name
    @Query("SELECT u.password FROM UserDetails u WHERE u.username = :name")
    String fetchPasswordByName(String name);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM UserDetails u WHERE u.username = :username AND u.password = :password")
    void deleteByUsernameAndPassword(String username, String password);
    
    boolean existsByUsernameAndPassword(String username, String password);
}