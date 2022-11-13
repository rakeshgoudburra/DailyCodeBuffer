package com.dailycodebuffer.orderservice.external.client.decoder;

import java.io.IOException;

import com.dailycodebuffer.orderservice.exception.CustomException;
import com.dailycodebuffer.orderservice.external.client.response.ErrorResponce;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class CustomErrorDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		// TODO Auto-generated method stub
		ObjectMapper objectMapper=new ObjectMapper();
		log.info("::{}",response.request().url());
		log.info("::{}",response.request().headers());
		try {
			ErrorResponce errorResponce=objectMapper.readValue(response.body().asInputStream(),ErrorResponce.class);
		return new CustomException(errorResponce.getErrorMsg(), errorResponce.getErrorCode(), response.status());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new CustomException("Internal server error", "INTERNAL_SERVER_ERROR", 500);
	}
		
	}

}
