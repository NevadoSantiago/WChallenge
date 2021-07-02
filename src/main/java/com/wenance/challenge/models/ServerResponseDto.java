package com.wenance.challenge.models;

public class ServerResponseDto {

	
	private Object response;
	private Integer status;
	private String message;
	
	public ServerResponseDto(Object response, Integer status, String message) {
		this.response = response;
		this.status = status;
		this.message = message;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMesagge() {
		return message;
	}

	public void setMesagge(String message) {
		this.message = message;
	}

	
	
	
}
