package com.service;

import org.springframework.stereotype.Service;

import com.config.DynamoDbRepo;
import com.dto.Employee;

@Service
public class EmployeeService {

	private final DynamoDbRepo dynamoDbRepo;

	public EmployeeService(DynamoDbRepo dynamoDbRepo) {

		this.dynamoDbRepo = dynamoDbRepo;
	}

	public void processEmployee(Employee employee) {

		System.out.println("Listener2 -- employee:" + employee);
		dynamoDbRepo.insertEmployee(employee);
	}
}
