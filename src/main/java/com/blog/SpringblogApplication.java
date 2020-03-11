package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.blog.mapper")
@SpringBootApplication
public class SpringblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringblogApplication.class, args);
    }

}
