package com.dailycodebuffer.ProductService.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ProductServiceCustomException extends RuntimeException{
 
	private String errorCode;
	
	public ProductServiceCustomException(String msg,String errorCode){
		super(msg);
		this.errorCode=errorCode;
	}
	
}
