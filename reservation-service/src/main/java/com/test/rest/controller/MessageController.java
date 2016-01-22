package com.test.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

	@Value("${message}")
	private String message;
	
	@RequestMapping("/message")
	String message(){
		System.err.println("hello");
		return "Ekram " + this.message;
	}
}
