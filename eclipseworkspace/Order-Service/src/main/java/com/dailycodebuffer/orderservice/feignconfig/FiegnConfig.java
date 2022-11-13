package com.dailycodebuffer.orderservice.feignconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dailycodebuffer.orderservice.external.client.decoder.CustomErrorDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class FiegnConfig {
	
    @Bean
	ErrorDecoder errorDecoder() {
		return new CustomErrorDecoder();
	}
}
