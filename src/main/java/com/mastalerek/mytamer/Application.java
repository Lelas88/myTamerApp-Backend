package com.mastalerek.mytamer;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

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
        SpringApplication.run(Application.class, args);
    }
}
