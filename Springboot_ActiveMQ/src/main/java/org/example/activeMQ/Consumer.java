package org.example.activeMQ;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "${activemq.destination}", containerFactory = "jmsListenerContainerFactory")
    public void processToDo(String message) {
        System.out.println("Consumer> " + message);
    }

}
