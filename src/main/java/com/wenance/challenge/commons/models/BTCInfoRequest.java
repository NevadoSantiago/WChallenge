package com.wenance.challenge.commons.models;

import java.util.Date;

public class BTCInfoRequest {

	private String lprice;
	private String curr1;
	private String curr2;
	private Date date;
	
	public String getLprice() {
		return lprice;
	}
	public void setLprice(String lprice) {
		this.lprice = lprice;
	}
	public String getCurr1() {
		return curr1;
	}
	public void setCurr1(String curr1) {
		this.curr1 = curr1;
	}
	public String getCurr2() {
		return curr2;
	}
	public void setCurr2(String curr2) {
		this.curr2 = curr2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
