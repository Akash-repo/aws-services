# aws-services

Simple Employee Registration App using SQS, DynamoDB, Lambda using Spring boot Microservices
Akash Singh
Akash Singh
3 hours ago·2 min read



This is a simple demo app which illustrates the working of Amazon SQS, DynamoDB, Lambda using Spring boot Microservices.
Image for post
I have created two Spring boot project. The code is available on my Git hub. I created these project using Spring Initializer. I’m running these two services on my local machine on port 8080 and 8081.
The service on 8080 is configured to act as both producer and consumer. This means it has a method which places the message on the SQS and also has method with listener annotation which polls for the message on the SQS.
The service running on port 8081 is just configured to act as a Consumer. So basically we have one producer and two consumer. So when a producer pushes a message on SQS, it will be randomly picked by any of the two consumer to process the message on SQS.
In the demo app the employee registration API is service running on 8080 puts the employee message on Amazon SQS and this message is randomly picked by any of the two consumer and inserts the message on the DynamoDB. The table Employee on DynamoDB has a primary column as Employee name.
To know which server has process the employee registration and inserted to DynamoDB, I also added the server port on the employee object before inserting into DynamoDB. I’m invoking the POST API on service running on 8080 using postman. The request body is simple JSON which is an employee object.
The insert into Dynamo Db invokes Lambda function which for demo purpose in just logging the details on the registered employee.
