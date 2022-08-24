package com.practice.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqApplication {

	public final String QUEUE = "message_queue";
	public final String EXCHANGE = "message_exchange";
	public final String ROUTINGKEY = "message_routing_key";

	@Bean
	Queue queue() {
		return new Queue(QUEUE);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY);
	}

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(QUEUE);
		container.setMessageListener(new RabbitMQListener());
		return container;
	}

	/*@Bean
	MessageListenerAdapter listenerAdapter(Bidder receiver) {
		return new MessageListenerAdapter(receiver.toString(), "receiveMessage");
	}*/

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}

}
