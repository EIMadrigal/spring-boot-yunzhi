package com.example.yunzhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@SpringBootApplication
public class YunzhiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunzhiApplication.class, args);
    }

}
