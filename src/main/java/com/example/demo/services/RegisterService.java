package com.example.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.utils.Utils;

@Service
public class RegisterService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Map<String, Object> register(Map<String, Object> data) {
		Map<String, Object> response = new HashMap<>();
		String email=data.get("email").toString().trim();
		String username=data.get("username").toString().trim();
		String password=data.get("password").toString().trim();
		String phone=data.get("phone").toString().trim();
		String name=data.get("name").toString().trim();
		
		if(userRepository.findByEmail(email)!=null) {
				response.put("Status", "Error");
				response.put("Message", "Email is already exist");
			return response;
		}
		else if(userRepository.findByUsername(username)!=null) {
				response.put("Status", "Error");
				response.put("Message", "Username already exist");
			return response;
		}
		else if(userRepository.findByPhone(phone)!=null) {
				response.put("Status", "Error");
				response.put("Message", "Phone number is already exist");
			return response;
		}
		else {
				User user=new User();
				user.setEmail(email);
				user.setPhone(phone);
				user.setName(name);
				user.setUsername(username);
				user.setPassword(Utils.hashPassword(password.toCharArray()));
				userRepository.save(user);
				
				response.put("Status", "Success");
				response.put("Message", "User registration successfull");
			return response;
		}
		
	}
	
	
	
}
