package org.sf.cloud.eureka.client.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "spring-cloud-eureka-client-a")
public interface ServiceAPingClient {

	@RequestMapping(method = RequestMethod.GET, value = "/ping", consumes = MediaType.TEXT_PLAIN_VALUE)
	String ping();

}
