package com.test;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	public static void main(String[] args) {
		BCryptPasswordEncoder crypt=new BCryptPasswordEncoder();
		
		String rawpass="sathya@123";
		String encodepass=crypt.encode(rawpass);
		System.out.println(encodepass);
	}

}
