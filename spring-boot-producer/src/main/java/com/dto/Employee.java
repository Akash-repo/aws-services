package com.dto;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="Employee")
public class Employee {
	
	@DynamoDBHashKey(attributeName="Id")
	private String Id;
	@DynamoDBAttribute(attributeName = "name")
	private String name;
	@DynamoDBAttribute(attributeName = "age")
	private String age;
	@DynamoDBAttribute(attributeName = "email")
	private String email;
	@DynamoDBAttribute(attributeName = "registrationDate")
	private String registrationDate;
	@DynamoDBAttribute(attributeName = "port")
	private String port;
	
	public Employee() {
	}
	
	@DynamoDBAttribute(attributeName = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@DynamoDBAttribute(attributeName = "age")
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@DynamoDBAttribute(attributeName = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@DynamoDBHashKey(attributeName="Id")
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	@DynamoDBAttribute(attributeName = "registrationDate")
	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", age=" + age + ", email=" + email + ", registrationDate="
				+ registrationDate + "]";
	}

	@DynamoDBAttribute(attributeName = "port")
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

}
