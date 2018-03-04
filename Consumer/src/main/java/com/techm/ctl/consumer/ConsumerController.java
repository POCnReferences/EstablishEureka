package com.techm.ctl.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ConsumerController {
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Value("${foreign.service}")
	private String producer;
	
	@RequestMapping("/instances")
	public List<String> msg()	{
		System.out.println(producer);
		List<ServiceInstance> instances=discoveryClient.getInstances(producer);
		List<String> uriList= new ArrayList<>();
		for (ServiceInstance serviceInstance : instances) {
			uriList.add(serviceInstance.getUri().toString());
		}
		return uriList;
	}
	
	
}
