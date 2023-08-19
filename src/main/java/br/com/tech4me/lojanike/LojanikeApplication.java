package br.com.tech4me.lojanike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LojanikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojanikeApplication.class, args);
	}

}
