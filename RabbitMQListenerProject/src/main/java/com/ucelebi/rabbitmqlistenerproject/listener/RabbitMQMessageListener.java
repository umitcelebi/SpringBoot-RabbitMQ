package com.ucelebi.rabbitmqlistenerproject.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author UMITCELEBI
 */
public class RabbitMQMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("Message= [" + new String(message.getBody())+"]");
    }
}
