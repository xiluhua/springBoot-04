package com.springBoot.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.entity.Customer;
import com.multi.service.impl.CustomerImpl;

@Controller
public class B4Action {

	@Resource
	CustomerImpl customerImpl;

	// postman
	// localhost:8004/boot04/b4.action
	@RequestMapping("/b4.action")
	public String test(Map<String, Object> map, Customer customer) {
		System.out.println("b4 ...");
		customerImpl.save(customer.getId(), customer);
		
		return "success";
	}
	
}
