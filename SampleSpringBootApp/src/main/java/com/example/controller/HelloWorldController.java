package com.example.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.WRRepositoryImpl;

@RestController
public class HelloWorldController {
	
	@Autowired
	@Qualifier("wrRepositoryImpl")
	private WRRepositoryImpl wrRepositoryImpl;
	
	@Autowired
    private Logger logger;
	
	@RequestMapping(name="/helloWorld", method=RequestMethod.GET)
	public String helloWorld(){
		
		logger.debug("debug");
		logger.info("info         EEEEEEEEEE");
		
		try {
			wrRepositoryImpl.insertEmployee();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello World";
		
	}

}
