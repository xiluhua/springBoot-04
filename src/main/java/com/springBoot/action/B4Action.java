package com.springBoot.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.entity.Customer;
import com.multi.entity.Order;
import com.multi.service.impl.CustomerImpl;
import com.multi.service.impl.OrderImpl;

@Controller
public class B4Action {

	@Resource
	CustomerImpl customerImpl;
	@Resource
	OrderImpl orderImpl;
	
	// postman
	// localhost:8004/boot04/b4.action
	@RequestMapping("/b4.action")
	public String test(Map<String, Object> map, Customer customer) {
		System.out.println("b4 ...");
		customerImpl.save(customer.getId(), customer);
		
		Order order = new Order(customer.getId(), "订单", customer.getId());
		orderImpl.save(order.getCustomerId(), order);
		return "success";
	}
	
}
