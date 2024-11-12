package com.example.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.ChatRepository;

@Service
public class DashboardService {
	
	@Autowired
	private ChatRepository chatRepository;
	
	public Map<String, Object> getAllContacts(Map<String, Object> data) {
		Map<String, Object> response = new HashMap<>();
		Long userId=Long.parseLong(data.get("UserId").toString().trim());
		boolean isExistAnyChat=chatRepository.isExistAnyChatById(userId);
		if(!isExistAnyChat) {
			response.put("Status", "Success");
			response.put("Message", "Start chatting");
			return response;
		}
		else {
			
			
			return null;
		}
		
		
	}
	
	
	
	
}
