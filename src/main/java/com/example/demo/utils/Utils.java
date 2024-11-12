package com.example.demo.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class Utils {
	
	private static final Argon2 argon2=Argon2Factory.create();
	
	//argon methods for handling hashing and verifying
	public static String hashPassword(char[] password) {
		return argon2.hash(2, 65536, 1, password);
	}
	public static boolean verifyPassword(char[] password,String hashPassword) {
		return argon2.verify(hashPassword, password);
		
	}
	
	
}
