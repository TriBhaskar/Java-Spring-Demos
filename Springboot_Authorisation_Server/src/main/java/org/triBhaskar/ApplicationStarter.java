package org.triBhaskar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}