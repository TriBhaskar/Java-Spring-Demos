package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/")
    public String sendReponse(){
        return "Welcome to Sample Controller";
    }
    @PostMapping("/send")
    public String sendMessage() {
        return "Hi your message is recieved";
    }
}
