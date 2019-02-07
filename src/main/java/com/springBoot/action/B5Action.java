package com.springBoot.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.entity.Customer;
import com.multi.service2.impl.Customer2Impl;

@Controller
public class B5Action {

	@Resource
	Customer2Impl customer2Impl;
	
	// postman
	// localhost:8004/boot04/b5.action
	@RequestMapping("/b5.action")
	public String test5(Map<String, Object> map, Customer customer) {
		System.out.println("b5 ...");
		customer2Impl.save(customer.getId(), customer);
		return "success";
	}
	
}
