package com.mastalerek.mytamer;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories(basePackages = { "com.mastalerek.mytamer.repository" })
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

    public static void main(String[] args) {
    	InetAddress ip;
    	String hostname;
    	try {
    		ip = InetAddress.getLocalHost();
    		hostname = ip.getHostName();
    		System.out.println("IP: " + ip);
    		System.out.println("Hostname: " + hostname);
    	} catch(UnknownHostException e) {
    		e.printStackTrace();
    	}
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
        builder.run(args);
    }
}
