package com.multi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.dao.CustomerDao;
import com.multi.dataSource.MultiDataSource;
import com.multi.entity.Customer;
import com.multi.service.CustomerService;

@MultiDataSource
@Transactional
@Service
public class CustomerImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	public void save(int id, Customer entity) {
		customerDao.save(entity);
	}
	
}
