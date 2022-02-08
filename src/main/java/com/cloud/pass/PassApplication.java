package com.cloud.pass;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication(scanBasePackages = { "com.cloud.pass.*", "io.grpc.stub.*" })
@EnableJpaRepositories("com.cloud.pass.*")
@EntityScan("com.cloud.pass.*")
public class PassApplication {
	private final static Logger log = Logger.getGlobal();
	public static void main(String... args) {
		SpringApplication.run(PassApplication.class, args);
	}
}