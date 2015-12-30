package com.mastalerek.mytamer.webapi.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.client.Entity;
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
			Integer groupId = groupService.createGroup(group);
			return Response.ok().entity(Entity.text(String.valueOf(groupId))).build();
		} catch (Exception e) {
			return Response.notModified().build();
		}
	}

	@Override
	public Response deleteGroup(Integer groupId) {
		try {
			groupService.deleteGroup(groupId);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.notModified().build();
		}
	}

	@Override
	public GroupWebModel getGroupDetails(Integer groupId) {
		return groupService.getGroupDetails(groupId);
	}

	@Override
	public Response linkStudents(Integer groupId, List<Integer> studentIds) {
		try {
			groupService.linkGroupAndStudents(groupId, studentIds);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.notModified().build();
		}
	}

	@Override
	public Response unassignStudent(Integer groupId, Integer studentId) {
		try {
			groupService.unassignStudent(groupId, studentId);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.notModified().build();
		}
	}

}
