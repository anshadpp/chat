package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	//for login
	@Query(value="select u from User u where u.email = :username or u.phone = :username or u.username = :username")
	User findPasswordByUsernameOrEmailOrPhone(@Param("username") String username);
	
	
	//for registration
	User findByEmail(String email);
	User findByUsername(String username);
	User findByPhone(String phone);
	
}
