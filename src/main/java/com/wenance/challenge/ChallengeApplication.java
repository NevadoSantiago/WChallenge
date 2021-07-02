package com.wenance.challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wenance.challenge.services.BTCService;

@SpringBootApplication
public class ChallengeApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
		BTCService service = new BTCService();
		service.getBTCData(10);
		
	}
}
