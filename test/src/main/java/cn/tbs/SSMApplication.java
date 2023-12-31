package cn.tbs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.tbs.mapper")
public class SSMApplication {
    public static void main(String[] args) {
        SpringApplication.run(SSMApplication.class);
    }
}
