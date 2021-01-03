package com.config;

import org.springframework.stereotype.Repository;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;
import com.dto.Employee;
import com.amazonaws.regions.Regions;

@Repository
public class DynamoDbRepo {

	public void insertEmployee(Employee e) {
		
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("ID", "KEY")))
				.withRegion(Regions.US_EAST_2)
				.build();
        Employee item = new Employee();
        try{
        	item.setId(e.getId());
        	item.setName(e.getName());
        	item.setAge(e.getAge());
        	item.setRegistrationDate(e.getRegistrationDate());
        	item.setPort("Listner2-8081");
            DynamoDBMapper mapper = new DynamoDBMapper(client);
            mapper.save(item);
            System.out.println("Done");
        } catch (AmazonDynamoDBException ex) {
        	System.out.println("Not Done");
            ex.getStackTrace();
        }
	}
 
}
