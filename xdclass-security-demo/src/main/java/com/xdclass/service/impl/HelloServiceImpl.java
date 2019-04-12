package com.xdclass.service.impl;

import org.springframework.stereotype.Service;

import com.xdclass.service.Helloservice;

@Service
public class HelloServiceImpl implements Helloservice{

	@Override
	public String hello(String name) {
		System.out.println("gooo");
		return "hello"+name;
	}

	

	

}
