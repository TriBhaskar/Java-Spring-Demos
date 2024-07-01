package org.example.activeMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private Producer producer;
    @Value("${activemq.destination}")
    private String destination;
    @GetMapping("/")
    public String sendReponse(){
        return "Welcome";
    }
    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        producer.sendMessage(destination,message);
        return "Message sent to the queue";
    }
}
