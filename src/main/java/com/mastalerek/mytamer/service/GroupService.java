package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Group;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.User;
import com.mastalerek.mytamer.functions.GroupEntityToGroupWebModelFunction;
import com.mastalerek.mytamer.repository.GroupRepository;
import com.mastalerek.mytamer.repository.StudentRepository;
import com.mastalerek.mytamer.repository.UserRepository;
import com.mastalerek.mytamer.webmodel.GroupWebModel;

@Component
public class GroupService {

	@Inject
	private StudentService studentService; 
	@Inject
	private GroupRepository groupRepository;
	@Inject
	private StudentRepository studentRepository;
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
		groupRepository.save(group);
	}

	public Integer createGroup(GroupWebModel groupModel) {
		User user = userRepository.findOne(groupModel.getTrainerId());
		Group group = new Group();
		group.setName(groupModel.getName());
		group.setUser(user);
		group.setId(groupModel.getId());
		Group newGroup = groupRepository.save(group);
		return newGroup.getId();
	}

	public void deleteGroup(Integer groupId) {
		studentService.unassignGroup(groupId);
		groupRepository.delete(groupRepository.findOne(groupId));
	}

	public GroupWebModel getGroupDetails(Integer groupId) {
		return groupEntityToGroupWebModelFunction.apply(groupRepository.findOne(groupId));
	}

	public void linkGroupAndStudents(Integer groupId, List<Integer> studentIds) {
		Group group = groupRepository.findOne(groupId);
		for (Integer studentId : studentIds) {
			Student student = studentRepository.findOne(studentId);
			student.setGroup(group);
			studentRepository.save(student);
		}
	}

	public void unassignStudent(Integer groupId, Integer studentId) {
		Student student = studentRepository.findOne(studentId);
		student.setGroup(null);
		studentRepository.save(student);
	}

}
