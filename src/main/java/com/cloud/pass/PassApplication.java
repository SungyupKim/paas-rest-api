package com.cloud.pass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.cloud.pass.*", "io.grpc.stub.*"}) 
@EnableJpaRepositories("com.cloud.pass.*")
@EntityScan("com.cloud.pass.*")
public class PassApplication {
  public static void main(String... args) {
    SpringApplication.run(PassApplication.class, args);
  }
}