package com.hcl.CreditCheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.hcl.CreditCheck" })

@SpringBootApplication
public class CreditCheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCheckApplication.class, args);
	}

}
