package com.multi.entity;

public class Order {

	private Integer id;
	private String orderName;
	private Integer customerId;

	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(Integer id) {
		super();
		this.id = id;
	}
	public Order(int id, String orderName, int customerId) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.customerId = customerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

    
}
