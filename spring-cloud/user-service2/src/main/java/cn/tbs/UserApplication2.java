package cn.tbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("cn.tbs.mapper")
@EnableDiscoveryClient
public class UserApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication2.class,args);
    }
}
