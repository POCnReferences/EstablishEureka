package com.techm.ctl.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
		/*RestTemplate restTemplate = new RestTemplate();
        String[] color = restTemplate.getForObject("http://localhost:9001/getColor", String[].class);
        System.out.println(color[0]);*/
	}
}
