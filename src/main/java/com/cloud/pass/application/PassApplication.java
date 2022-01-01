package com.cloud.pass.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cloud.pass.*"}) 
public class PassApplication {
  public static void main(String... args) {
    SpringApplication.run(PassApplication.class, args);
  }
}