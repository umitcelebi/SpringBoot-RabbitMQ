package com.ucelebi.rabbitmqlistenerproject.config;


import com.ucelebi.rabbitmqlistenerproject.listener.RabbitMQMessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author UMITCELEBI
 */
@Configuration
public class RabbitMQConfig {

    private static final String MY_QUEUE="testQueue";

    @Bean
    Queue myQueue(){
        return new Queue(MY_QUEUE,true);
    }

    @Bean
    ConnectionFactory connectionFactory(){
        CachingConnectionFactory cachingConnection=new CachingConnectionFactory("localhost");
        cachingConnection.setUsername("guest");
        cachingConnection.setPassword("guest");
        return cachingConnection;
    }

    @Bean
    MessageListenerContainer messageListenerContainer(){
        SimpleMessageListenerContainer simpleMessageListenerContainer=new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        simpleMessageListenerContainer.setMessageListener(new RabbitMQMessageListener());
        return simpleMessageListenerContainer;
    }

}
