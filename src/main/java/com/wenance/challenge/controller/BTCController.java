package com.wenance.challenge.controller;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenance.challenge.models.ServerResponseDto;
import com.wenance.challenge.services.BTCService;

@RequestMapping("/api/BTC")
@RestController
public class BTCController {

	@Autowired
	BTCService service;
	
	@GetMapping("/getPrice/{time}")
	public ResponseEntity<ServerResponseDto> getBTCPriceByTimeStamp(
			@PathVariable("time") @DateTimeFormat(pattern = "dd-MM-yyyy'T'H:mm:ss") Date time){
		try {
			String price = service.getPriceByDate(time);
			ServerResponseDto response = new ServerResponseDto(price,200,"Success");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			ServerResponseDto response = new ServerResponseDto(null,202,"No value present");
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		}
		
		
	}
	@GetMapping("/getAverage/{from}/{to}")
	public ResponseEntity<ServerResponseDto> getBTCAverageBetweenTimeStamp(
			@PathVariable("from") @DateTimeFormat(pattern = "dd-MM-yyyy'T'H:mm:ss") Date from,
			@PathVariable("to") @DateTimeFormat(pattern = "dd-MM-yyyy'T'H:mm:ss") Date to){
		ServerResponseDto response = new ServerResponseDto(service.getInfoBTCBetweenDates(from, to),200,"Success");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
