package com.hcl.CreditCheck.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.CreditCheck.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

	List<Account> findByAccountId(String accountId);

}