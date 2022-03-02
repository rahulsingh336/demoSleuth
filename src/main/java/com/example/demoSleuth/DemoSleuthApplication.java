package com.example.demoSleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class DemoSleuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSleuthApplication.class, args);
	}

	/**
	 * THIS FOR ASYNCRONOUS PROCESS/METHOD
	 * @return
	 */
	@Bean(name="processExecutor")
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(5);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("Asynchronous Process-");
		executor.initialize();
		return executor;
	}

}
