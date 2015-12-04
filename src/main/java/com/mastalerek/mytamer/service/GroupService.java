package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Group;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.functions.GroupEntityToGroupWebModelFunction;
import com.mastalerek.mytamer.repository.GroupRepository;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.GroupWebModel;

@Component
public class GroupService {

	@Inject
	private GroupRepository groupRepository;
	@Inject
	private UserRepository userRepository;
	@Inject
	private GroupEntityToGroupWebModelFunction groupEntityToGroupWebModelFunction;
	
	public List<GroupWebModel> getGroupsByUserId(Integer userId) {
		List<Group> groups = groupRepository.findByUserId(userId);
		List<GroupWebModel> groupWebModelList = Lists.newArrayList();
		for (Group group : groups) {
			groupWebModelList.add(groupEntityToGroupWebModelFunction.apply(group));
		}
		return groupWebModelList;
	}

	public void updateGroup(GroupWebModel groupModel) {
		Group group = groupRepository.findOne(groupModel.getId());
		group.setName(groupModel.getName());
		group.setId(groupModel.getId());
		groupRepository.save(group);
	}

	public void createGroup(GroupWebModel groupModel) {
		User user = userRepository.findOne(groupModel.getTrainerId());
		Group group = new Group();
		group.setName(groupModel.getName());
		group.setUser(user);
		group.setId(groupModel.getId());
		groupRepository.save(group);
	}

}
