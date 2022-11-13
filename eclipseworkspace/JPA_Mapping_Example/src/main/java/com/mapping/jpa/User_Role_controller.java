package com.mapping.jpa;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.jpa.entity.User;

@RestController
public class User_Role_controller {
	
   @PostMapping("/")
	public String postController(@RequestBody User user) {
	   
	   
		return null;
		
	}
}
