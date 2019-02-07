package com.multi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.multi.entity.Customer;

@Repository
public class CustomerDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public List<Customer> find(){
		
		String sql = "select last_name, age from JPA_CUSTOMERS";
		
		List<Customer> list = jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet arg0, int arg1)
					throws SQLException {
				Customer model = new Customer();
				model.setLastName(arg0.getString("last_name"));
				model.setAge(arg0.getInt("age"));
				return model;
			}
		});
		
		return list;
	}
	
	public void save(Customer entity){
		String sql = "insert into JPA_CUSTOMERS(id,last_name,age)values(?,?,?)";
		
		Object args[] = {entity.getId(),entity.getLastName(),entity.getAge()};
		
		jdbcTemplate.update(sql, args);
	}
	
}
