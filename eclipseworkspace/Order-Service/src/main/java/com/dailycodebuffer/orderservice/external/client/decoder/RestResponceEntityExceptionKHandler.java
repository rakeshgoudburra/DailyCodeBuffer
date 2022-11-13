package com.dailycodebuffer.orderservice.external.client.decoder;

import org.springframework.http.HttpStatus;
import com.dailycodebuffer.orderservice.external.client.response.ErrorResponce;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice; 
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.dailycodebuffer.orderservice.exception.CustomException;

@ControllerAdvice
public class RestResponceEntityExceptionKHandler {
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponce> handleCustomExceptionHandler(CustomException customException){
		ErrorResponce respone=new ErrorResponce().builder().errorMsg(customException.getMessage())
				.errorCode(customException.getErrorCode()).build();
		return new ResponseEntity<ErrorResponce>(respone, HttpStatus.valueOf(customException.getStatus()));
	}

}
