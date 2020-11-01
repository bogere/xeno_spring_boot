/**
 * 
 */
package com.example.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import com.example.demo.model.LoginUser;
//import com.example.demo.model.ApiResponse;
import com.example.demo.repository.UserRepository;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author goldsoft25
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthAPIController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	
	@PostMapping("/auth/login")
	public LoginUser login(@RequestParam("username") String username, @RequestParam("password") String pwd)
	{  
		//check if user exists in the database.
		User registeredUser = 
				userRepository.findByUsername(username);
		 		              //.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
	    if(registeredUser != null) {
	    	//check if the password hashes match
	    	if(bcryptEncoder.matches(pwd, registeredUser.getPassword())) {
	    		String token = getJWTToken(username);
				LoginUser user = new LoginUser();
				user.setUser(username);
				user.setToken(token);
				user.setPwd(pwd);
				return user;
	    	}else {
	            LoginUser  user = new LoginUser();
	            user.setUser(username);
	            user.setToken("No token generated");
	            user.setPwd("Incorrect password provided");
	            return user;
	            
	    	}
	    }else {
	       LoginUser user = new LoginUser();
	       user.setUser(username);
	       user.setToken("No token generated");
	       user.setPwd("The username does not exist");
	       return user; //empty user
	    }   
		
	}
	
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("XenoSchoolJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (24*60*60*1000))) //24 hours
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
	
	/**
	   * Create user map.
	   *
	   * @param user the user id
	   * @return the map
	   * @throws Exception the exception
	   */
	@PostMapping("/auth/createUser")
	public Map<String, Boolean> createUser(@Valid @RequestBody User user) throws Exception {
	     
	    Map<String, Boolean> response = new HashMap<>();
	    //check if the user already exists in the database.
	    User existingUser = userRepository.findByEmail(user.getEmail());
	    if(existingUser != null) {
	    	response.put("success", Boolean.FALSE);
	    	response.put("Email address already taken", Boolean.TRUE);
	    	
		    return response;
	    }else {
	    	//what about hashing the password before saving the user in the database.
	    	user.setPassword(bcryptEncoder.encode(user.getPassword()));
	    	userRepository.save(user);
	    	response.put("success", Boolean.TRUE);
	    	response.put("User created successful", Boolean.TRUE);
		    return response;
	    }
	  }
  

}
