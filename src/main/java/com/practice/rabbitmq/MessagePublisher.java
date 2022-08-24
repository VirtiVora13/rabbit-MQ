package com.practice.rabbitmq;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

@Controller
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/setBidder")
    public String setMessage(@RequestParam String bid) throws IOException, TimeoutException {
        template.convertAndSend("message_exchange", "message_routing_key", bid.toString());
        /*ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.basicPublish("exchangeTest", "routingKeyTest", null, bidder.toString().getBytes());

        channel.close();
        connection.close();*/

        return "home";
    }

    /*@GetMapping("/home")
    public String getHome(){
        return "home";
    }*/

}
