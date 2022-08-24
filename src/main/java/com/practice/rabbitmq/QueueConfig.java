/*
package com.practice.rabbitmq;


import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.amqp.core.*;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Component
public class QueueConfig {
    public static final String QUEUE = "message_queue";
    public static final String EXCHANGE = "message_exchange";
    public static final String ROUTINGKEY = "message_routing_key";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange){

        return BindingBuilder
                .bind(queue)
                .to(topicExchange)
                .with(ROUTINGKEY);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE);
        container.setMessageListener(listenerAdapter);
        MessageListener listener = (MessageListener) container.getMessageListener();
        listener.onMessage(new Message("yo yo".getBytes(StandardCharsets.UTF_8)));
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Bidder bidder) {
        return new MessageListenerAdapter(bidder, "receiveMessage");
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

    */
/*@Bean
    public void config(){
        com.rabbitmq.client.ConnectionFactory factory = new ConnectionFactory();
        Connection connection = null;
        try {
            connection = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        Channel channel = null;
        try {
            channel = connection.createChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Creating Exchange
        Map<String, Object> exchangeArguments = new HashMap<>();
        exchangeArguments.put("alternate-exchange", "orders-alternate-exchange");
        try {
            channel.exchangeDeclare("exchangeTest", BuiltinExchangeType.DIRECT, true, false, exchangeArguments);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Creating Queue
        Map<String, Object> queueArguments = new HashMap<>();
        queueArguments.put("x-message-ttl", 60000);
        queueArguments.put("x-max-priority", 10);
        try {
            channel.queueDeclare("queueTest", true, false, false, queueArguments);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Binding Queue
        try {
            channel.queueBind("queueTest", "exchangeTest", "routingKeyTest");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //channel.basicPublish(QueueConfig.EXCHANGE, QueueConfig.ROUTINGKEY, null, bidder.toString().getBytes());

        try {
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*//*

}
*/
