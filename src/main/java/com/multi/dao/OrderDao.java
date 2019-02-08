package com.multi.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.multi.entity.Order;

@Repository
public class OrderDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public void save(Order entity){
		String sql = "insert into JPA_ORDERS(id,orderName,CUSTOMER_ID)values(?,?,?)";
		
		Object args[] = {entity.getId(),entity.getOrderName(),entity.getCustomerId()};
		
		jdbcTemplate.update(sql, args);
	}
	
}
