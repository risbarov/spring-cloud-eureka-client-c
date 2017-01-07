package org.sf.cloud.eureka.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.sf.cloud.eureka.client.feign.ServiceAClient;
import org.sf.cloud.eureka.client.feign.ServiceBClient;

@RestController
public class ApplicationController {

	@Autowired
	private ServiceAClient serviceAClient;

	@Autowired
	private ServiceBClient serviceBClient;

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "Spring Cloud Eureka client C is running...";
	}

	@RequestMapping("/invokeClients")
	@ResponseBody
	public String invokeClients() {
		String serviceAPing = serviceAClient.ping();
		String serviceBPing = serviceBClient.ping();

		return String.format("Service A response: [%s]. Service B response: [%s].", serviceAPing, serviceBPing);
	}

}
