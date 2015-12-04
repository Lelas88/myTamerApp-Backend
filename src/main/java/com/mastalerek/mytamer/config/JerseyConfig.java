package com.mastalerek.mytamer.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.webapi.impl.GroupWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.UserWebApiImpl;

@Component
@ApplicationPath("/mytamer")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(UserWebApiImpl.class);
		register(GroupWebApiImpl.class);
	}
}
