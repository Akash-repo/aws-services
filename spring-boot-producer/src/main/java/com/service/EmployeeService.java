package com.service;

import com.cofig.DynamoDbRepo;
import com.dto.Employee;
import com.enums.MessageType;
import com.producer.SqsMessageProducer;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class EmployeeService {

		private final DynamoDbRepo dynamoDbRepo;
		private final SqsMessageProducer producer;
		
		public EmployeeService( SqsMessageProducer producer, DynamoDbRepo dynamoDbRepo) {
			this.producer = producer;
			this.dynamoDbRepo = dynamoDbRepo;
		}


		public void processEmployee(Employee employee) {

			System.out.println("Listener1 -- employee:" + employee);
			dynamoDbRepo.insertEmployee(employee);
		}
		
		
		 public Employee addEmployee(Employee employee) {
			 employee.setId(UUID.randomUUID().toString());
			 employee.setRegistrationDate(new Date().toString());

		        Map<String, Object> headers = new HashMap<>();
		        headers.put("Message-Type", MessageType.EMPLOYEE.name());
		        headers.put("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		        this.producer.send(employee, headers);
		        return employee;
		    }
		
	}

