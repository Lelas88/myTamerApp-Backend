package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.GroupService;
import com.mastalerek.mytamer.webapi.GroupWebApi;
import com.mastalerek.mytamer.webmodel.GroupWebModel;

@Component
public class GroupWebApiImpl implements GroupWebApi {

	@Inject
	GroupService groupService;

	@Override
	public List<GroupWebModel> getGroupsByUserId(Integer userId) {
		return groupService.getGroupsByUserId(userId);
	}

	@Override
	public Response updateGroup(GroupWebModel group) {
		try {
			groupService.updateGroup(group);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.notModified().build();
		}
	}

	@Override
	public Response createGroup(GroupWebModel group) {
		try {
			groupService.createGroup(group);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.notModified().build();
		}
	}

}