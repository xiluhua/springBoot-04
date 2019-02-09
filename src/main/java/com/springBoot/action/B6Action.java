package com.springBoot.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.entity.Customer;
import com.springBoot.example.impl.Customer3Impl;

@Controller
public class B6Action {

	@Resource
	Customer3Impl customer3Impl;
	
	// postman
	// localhost:8004/boot04/b6.action
	@RequestMapping("/b6.action")
	public String test5(Map<String, Object> map, Customer customer) {
		System.out.println("b6 ...");
		customer3Impl.save(customer.getId(), customer);
		return "success";
	}
	
}
