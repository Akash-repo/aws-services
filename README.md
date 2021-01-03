# aws-services

Simple Employee Registration App using SQS, DynamoDB, Lambda using Spring boot Microservices
I have created two Spring boot project(Microservices) and one Maven Project which is a Lambda Function.I created these project using Spring Initializr. These two microservice are running on my local machine on port 8080 and 8081.
The Service1 on 8080 is configured to act as both producer and consumer. This means it has a method which places the message on the SQS and also has method with listener annotation which polls for the message on the SQS.
The Service2 running on port 8081 is just configured to act as a Consumer. So basically we have one producer and two consumer. So when a producer pushes a message on SQS, it will be randomly picked by any of the two consumer to process the message on SQS.
In the demo app, the employee registration API is a part of Service1 which is running on port 8080, when a user make post call through a Postman with a employee object as a request, the API puts the employee message(JSON) on Amazon SQS and this message is randomly picked by any of the two consumer(Service1 or Service2) and inserts the message on the Employee table of DynamoDB.
To know which server has process the employee registration and inserted to DynamoDB, I also added the server port on the employee object before inserting into DynamoDB. I’m invoking the POST API on service running on 8080 using postman. The request body is simple JSON which is an employee object.
The insert into Dynamo Db invokes Lambda function which for demo purpose in just logging the details on the registered employee using Dynamodb Stream Record.
