package com.mastalerek.mytamer.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.internal.MultiPartWriter;

import com.mastalerek.mytamer.webapi.UserWebApi;
import com.mastalerek.mytamer.webmodel.UserWebClientModel;

public class UserClient {

	private WebTarget target;
	private UserWebApi api;

	public UserClient(String url) {
		ClientConfig cc = new ClientConfig().register(new JacksonFeature());
		cc.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
		cc.register(MultiPartWriter.class);
		Client client = ClientBuilder.newClient(cc);
		target = client.target(url);
		api = WebResourceFactory.newResource(UserWebApi.class, target);
	}
	
	public UserWebClientModel getUserByUsername(String username) {
		return api.getUserByUsername(username);
	}
	
	public List<UserWebClientModel> getAllUsers() {
		return api.getAllUsers();
	}
}
