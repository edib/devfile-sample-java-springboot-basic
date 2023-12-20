package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@SpringBootApplication
public class DemoApplication {
 
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @RequestMapping("/")
    String home() {
        logger.info("home() method called"); // Log a message when home() is called
        return "Merhaba OpenShift!";
    }



    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
