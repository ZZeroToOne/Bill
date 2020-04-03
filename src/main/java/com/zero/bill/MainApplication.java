package com.zero.bill;


import com.zero.bill.bean.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        UserEntity a=new UserEntity();
        SpringApplication.run(MainApplication.class, args);
    }

}
