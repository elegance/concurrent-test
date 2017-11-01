package org.orh.concurrenttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConcurrentTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcurrentTestApplication.class, args);
	}

}
