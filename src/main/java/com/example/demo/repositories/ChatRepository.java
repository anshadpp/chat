package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {
	
	
	@Query(value="Select COUNT(c) > 0 from Chat c where c.User.userIdId = :userId or c.recieverId = :userId")
	boolean isExistAnyChatById(Long userId);

}
