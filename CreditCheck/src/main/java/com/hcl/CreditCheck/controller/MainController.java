package com.hcl.CreditCheck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hcl.CreditCheck.model.Account;
import com.hcl.CreditCheck.model.Message;
import com.hcl.CreditCheck.model.Response;
import com.hcl.CreditCheck.service.AccountService;

@RestController
public class MainController {

	
	@PostMapping(value="/creditCheck")
    public Response getMessage(@RequestBody Message message) {
    	Response user = new Response();
    	try{
    		user = userService.get(login.getUsername());
    	}catch(UsernameNotFoundException e) {
    		return new User();
    	}
    	if(login.getPassword().equals(user.getPassword())) {
    		userService.putLogin(user.getUsername());
    		return user;
    	}else {
    		return new User();
    	}
    }
}
