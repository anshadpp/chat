package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.DashboardService;
import com.example.demo.services.LoginService;
import com.example.demo.services.RegisterService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private DashboardService dashboardService;

	Map<String, Object> response = new HashMap<>();

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, Object> data) {
		if (data.get("username") == null || data.get("password") == null
				|| data.get("username").toString().trim().isEmpty()
				|| data.get("password").toString().trim().isEmpty()) {

			response.put("Status", "Error");
			response.put("Message", "All parameteres required");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		} else {
			response = loginService.validateLogin(data);
			if (response.get("Status").toString().equals("Error")) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			} else {
				return ResponseEntity.ok(response);
			}
		}
	}

	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> register(@RequestBody Map<String, Object> data) {
		if (data.get("email") == null || data.get("username") == null || data.get("email").toString().isEmpty()
				|| data.get("username").toString().isEmpty() || data.get("password") == null
				|| data.get("password").toString().isEmpty() || data.get("name") == null
				|| data.get("name").toString().isEmpty() || data.get("phone") == null
				|| data.get("phone").toString().isEmpty()) {

			response.put("Status", "Error");
			response.put("Message", "All parameter required");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		} else {
			response = registerService.register(data);
			if (response.get("Status").toString().equals("Error")) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
			} else {
				return ResponseEntity.ok(response);
			}
		}
	}
	
	@GetMapping("/dashboard")
	public ResponseEntity<Map<String, Object>> dashboard(@RequestParam Map<String, Object> data){
		response = dashboardService.getAllContacts(data);
		if (response.get("Status").toString().equals("Error")) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		} else {
			return ResponseEntity.ok(response);
		}
		
	}
}
