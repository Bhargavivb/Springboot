package com.wipro.sp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class RabbitMqConsumer {
	
	@Autowired
	SpRepository repository;

	@RabbitListener(queues = "${rabbitmq.queue}")
	public void recievedMessage(StudentSubscriptionModel stusub) {
		
		repository.save(stusub);
		System.out.println("Recieved Message From RabbitMQ: " + stusub);
	}
	
	
}