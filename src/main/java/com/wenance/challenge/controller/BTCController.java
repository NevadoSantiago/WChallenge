package com.wenance.challenge.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wenance.challenge.services.BTCService;

@RequestMapping("/api/BTC")
@RestController
public class BTCController {

	@Autowired
	BTCService service;
	
	@GetMapping("/getPrice/{time}")
	public ResponseEntity<?> getBTCPriceByTimeStamp(
			@PathVariable("time") @DateTimeFormat(pattern = "dd-MM-yyyy'T'H:mm:ss") Date time){
		String price = service.getPriceByDate(time);
		return new ResponseEntity<>(price, HttpStatus.OK);
	}
	@GetMapping("/getAverge/{from}/{to}")
	public ResponseEntity<?> getBTCAverageBetweenTimeStamp(
			@PathVariable("from") @DateTimeFormat(pattern = "dd-MM-yyyy'T'H:mm:ss") Date from,
			@PathVariable("to") @DateTimeFormat(pattern = "dd-MM-yyyy'T'H:mm:ss") Date to){
		return new ResponseEntity<>(service.getInfoBTCBetweenDates(from, to), HttpStatus.OK);
	}
}
