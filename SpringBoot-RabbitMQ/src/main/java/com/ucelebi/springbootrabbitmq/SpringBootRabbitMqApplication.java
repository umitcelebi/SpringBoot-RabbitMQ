package com.ucelebi.springbootrabbitmq;

import com.ucelebi.springbootrabbitmq.model.SimpleMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootRabbitMqApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitMqApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SimpleMessage simpleMessage=new SimpleMessage.Builder().name("Message").description("Simple Message Description").build();
        rabbitTemplate.convertAndSend("TestExchange","TestRouting",simpleMessage);
    }
}
