package com.multi.entity;

import java.util.Date;

public class Customer {

	private Integer id;
	private String lastName;

	private String email;
	private Integer age;
	private Integer addr_id;

	private Date createdTime;
	private Date birth;


	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer id) {
		super();
		this.id = id;
	}
	public Customer(String lastName, int age) {
		super();
		this.lastName = lastName;
		this.age = age;
	}
	public Customer(int id, String lastName, int age) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getInfo(){
		return "lastName: " + lastName + ", email: " + email;
	}

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getAddr_id() {
		return addr_id;
	}
	public void setAddr_id(Integer addr_id) {
		this.addr_id = addr_id;
	}
    
    
}
