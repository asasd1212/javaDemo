package com.yh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@MapperScan("com.yh.mapper")
@SpringBootApplication
public class SSMApplication {
    public static void main(String[] args) {
        SpringApplication.run(SSMApplication.class);

        String encode = new BCryptPasswordEncoder().encode("520");
        System.out.println(encode);

        // 可以使用 new BCryptPasswordEncoder().matches()
        // 方法来验证用户输入的密码是否与存储在数据库中的已加密密码匹配
        boolean matches = new BCryptPasswordEncoder().matches("520", encode);
        System.out.println(matches);
    }
}
