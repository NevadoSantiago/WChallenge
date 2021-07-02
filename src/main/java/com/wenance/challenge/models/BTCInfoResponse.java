package com.wenance.challenge.models;

public class BTCInfoResponse {

	private Double averge;
	private Double perDiff;
	
	public BTCInfoResponse(double average, double perDiff) {
		this.averge = average;
		this.perDiff= perDiff;
	}
	
	public Double getAverge() {
		return averge;
	}
	public void setAverge(Double averge) {
		this.averge = averge;
	}
	public Double getPerDiff() {
		return perDiff;
	}
	public void setPerDiff(Double perDiff) {
		this.perDiff = perDiff;
	}
	
	
	
}
