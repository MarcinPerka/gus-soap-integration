package com.archu.gussoapintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GusSoapIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GusSoapIntegrationApplication.class, args);
    }

}
