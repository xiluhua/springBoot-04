package com.springBoot.example.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.dao.CustomerDao;
import com.multi.dataSource.MultiDataSource;
import com.multi.entity.Customer;
import com.multi.log.LogBefore;
import com.springBoot.example.Customer2Service;

@Transactional
@Service
public class Customer2Impl implements Customer2Service{

	@Autowired
	private CustomerDao customerDao;
	
	@LogBefore
	@MultiDataSource
	public void save(int id, Customer entity) {
		customerDao.save(entity);
	}
	
}
