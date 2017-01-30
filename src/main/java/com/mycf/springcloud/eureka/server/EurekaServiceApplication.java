package com.mycf.springcloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableEurekaServer
@SpringBootApplication
//@EnableHystrixDashboard
@EnableTurbine
public class EurekaServiceApplication {
    
    public static void main(String[] args) {
    	//set this property to let spring look for a specific file for eureka server configuration
    	//than the default /src/main/resource/application.yaml or /src/mian/resource/application.properties
    	//System.setProperty("spring.config.name", "registration-server");
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}
