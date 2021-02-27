package com.hcl.CreditCheck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.CreditCheck.model.Account;
import com.hcl.CreditCheck.repository.AccountRepository;

@Transactional
@Service
public class AccountService {
	@Autowired
	public AccountRepository accountRepository;
	
	public boolean existsbyId(int id) {
    	return accountRepository.existsById(id);
    }
    
    public List<Account> get(String AccountId) { //Read
    	return accountRepository.findByAccountId(AccountId);
    }
}
