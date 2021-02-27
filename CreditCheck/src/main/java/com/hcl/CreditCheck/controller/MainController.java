package com.hcl.CreditCheck.controller;

import java.util.List;

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
	@Autowired
	AccountService accountService;
	
	@PostMapping(value="/creditCheck")
    public Response getMessage(@RequestBody Message message) {
    	Response response = new Response();
    	List<Account> debtor = accountService.get(message.getDebtorAccount());
    	
    	// Validation
    	if(debtor.isEmpty()) { // Check whether Debtor Account exists
    		response.setTransactionStatus("Account not found");
    		return response;
    	} else if(debtor.get(0).getStatus() == "CLOSED") { // Check whether Debtor Account is closed
    		response.setTransactionStatus("Account closed");
    		return response;
    	} else if(debtor.get(0).getBalance() < message.getPaymentAmount()) { // Check whether Debtor Account has a sufficient balance
    		response.setTransactionStatus("Insufficient Balance");
    		return response;
    	} else { // Authorize if validation is passed
    		response.setTransactionStatus("Authorized");
    		return response;
    	}
    }
}
