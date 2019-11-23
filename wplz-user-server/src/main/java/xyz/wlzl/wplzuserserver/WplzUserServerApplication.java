package xyz.wlzl.wplzuserserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WplzUserServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WplzUserServerApplication.class, args);
	}

}
