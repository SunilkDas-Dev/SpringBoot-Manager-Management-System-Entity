package com.example.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class ResponseMessageDto {
	private Integer statusCode;
	private String message;
	private String status;
	private Object data;


	public ResponseMessageDto(Integer statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;

	}

	

	public ResponseMessageDto(Integer statusCode, String message, Object data) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public ResponseMessageDto(Integer statusCode, String message, String status, Object data) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.status = status;
		this.data = data;
	}

}
