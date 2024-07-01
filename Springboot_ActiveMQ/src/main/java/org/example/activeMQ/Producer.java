package org.example.activeMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;
    public void sendMessage(String destination,String message) {
        jmsTemplate.convertAndSend(destination,message);
        System.out.println("Producer> Message Sent");
    }
}
