package com.example.demo;

import javax.servlet.http.HttpServletRequest;
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
        String clientIP = getClientIP();
        logger.info("Client IP: " + clientIP);
        return "Merhaba OpenShift!";
    }

    private String getClientIP() {
        String clientIP = request.getHeader("X-Forwarded-For");
        if (clientIP == null || clientIP.isEmpty() || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getHeader("Proxy-Client-IP");
        }
        if (clientIP == null || clientIP.isEmpty() || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIP == null || clientIP.isEmpty() || "unknown".equalsIgnoreCase(clientIP)) {
            clientIP = request.getRemoteAddr();
        }
        return clientIP;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
