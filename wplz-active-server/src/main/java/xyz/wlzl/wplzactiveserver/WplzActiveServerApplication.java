package xyz.wlzl.wplzactiveserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableDiscoveryClient
public class WplzActiveServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WplzActiveServerApplication.class, args);
	}

}
