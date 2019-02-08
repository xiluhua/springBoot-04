package com.multi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.dao.OrderDao;
import com.multi.dataSource.MultiDataSource;
import com.multi.entity.Order;
import com.multi.service.OrderService;

@MultiDataSource
@Transactional
@Service
public class OrderImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	public void save(int id, Order entity) {
		orderDao.save(entity);
	}
	
}
