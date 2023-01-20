package com.sau.badmintonhallinformationmanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sau.badmintonhallinformationmanagementsystem.mapper")
public class BadmintonHallInformationManagementSystemApplication {

  public static void main(String[] args) {
    SpringApplication.run(BadmintonHallInformationManagementSystemApplication.class, args);
  }

}
