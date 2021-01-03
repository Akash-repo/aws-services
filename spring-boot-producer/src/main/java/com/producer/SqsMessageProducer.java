package com.producer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class SqsMessageProducer {


    private final QueueMessagingTemplate queueMessagingTemplate;

    @Value("${employee.queue.name}")
    private String employeeQ;

    @Autowired
    public SqsMessageProducer(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }

    public <T> void send(T message, Map<String, Object> headers) {
        if (message == null) {

            return;
        }
        System.out.println("message:"+message);
        queueMessagingTemplate.convertAndSend(employeeQ, message, headers);
    }
    

}
