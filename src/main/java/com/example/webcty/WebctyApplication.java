package com.example.webcty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WebctyApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebctyApplication.class, args);
    }

}
