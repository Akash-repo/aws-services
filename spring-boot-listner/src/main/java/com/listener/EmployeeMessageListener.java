package com.listener;

import com.dto.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.EmployeeService;

import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMessageListener {

    private static final ObjectMapper OBJECT_MAPPER = Jackson2ObjectMapperBuilder.json().build();
    
    private final EmployeeService employeeService;

    public EmployeeMessageListener(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @SqsListener(value = "${employee.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(String message) {
        try {
        	Employee employee = OBJECT_MAPPER.readValue(message, Employee.class);

            this.employeeService.processEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException("Cannot process message from SQS", e);
        }
    }
}
