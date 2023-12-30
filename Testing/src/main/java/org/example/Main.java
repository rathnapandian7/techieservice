package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }

}