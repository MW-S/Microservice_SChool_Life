package net.mw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication_8002 {
    public static void main(String[] args){
        SpringApplication.run(EurekaApplication_8002.class, args);
    }
}
