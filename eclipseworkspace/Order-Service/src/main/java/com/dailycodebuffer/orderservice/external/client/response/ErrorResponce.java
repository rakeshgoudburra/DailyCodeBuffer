package com.dailycodebuffer.orderservice.external.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponce {
 
	
	private String errorMsg;
	
	private String errorCode;
}
