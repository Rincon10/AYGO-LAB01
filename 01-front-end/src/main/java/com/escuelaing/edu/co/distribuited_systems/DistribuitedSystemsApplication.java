package com.escuelaing.edu.co.distribuited_systems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Collections;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class DistribuitedSystemsApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DistribuitedSystemsApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
        app.run(args);
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 33025;
    }

}
