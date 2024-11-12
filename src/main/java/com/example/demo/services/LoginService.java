package com.example.demo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.utils.Utils;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Map<String, Object> validateLogin(Map<String, Object> data) {
		Map<String, Object> response=new HashMap<>();
		
		String username=data.get("username").toString().trim();
		String password=data.get("password").toString().trim();
		
		User user=userRepository.findPasswordByUsernameOrEmailOrPhone(username);
		String dbPassword=user.getPassword();
		if(dbPassword==null) {
				response.put("Status", "Error");
				response.put("Message", "invalid username");
			return response;
			
		}
		else {
			
			if(!Utils.verifyPassword(password.toCharArray(), dbPassword)) {
					response.put("Status", "Error");
					response.put("Message", "Password is incorrect");
				return response;
			}
			else {
					response.put("UserId",user.getUserId());
					response.put("Status", "Success");
					response.put("Message", "Login Success");
				return response;
			}
		}
		
		
	}

}
