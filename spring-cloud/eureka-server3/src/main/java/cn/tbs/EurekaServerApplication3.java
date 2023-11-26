package cn.tbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication3 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication3.class,args);
    }
}
