package com.dailycodebuffer.ProductService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dailycodebuffer.ProductService.model.ErrorResponce;

@ControllerAdvice
public class RestResponceEntityExceptionKHandler {
	@ExceptionHandler(ProductServiceCustomException.class)
	public ResponseEntity<ErrorResponce> handleProductServiceExceptionHandler(ProductServiceCustomException customException){
		ErrorResponce respone=new ErrorResponce().builder().errorMsg(customException.getMessage())
				.errorCode(customException.getErrorCode()).build();
		return new ResponseEntity<ErrorResponce>(respone, HttpStatus.NOT_FOUND);
	}

}
