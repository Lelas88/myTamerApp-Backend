package com.mastalerek.mytamer.functions;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.mastalerek.mytamer.entity.Group;
import com.mastalerek.mytamer.webmodel.GroupWebModel;

@Service
public class GroupEntityToGroupWebModelFunction implements Function<Group, GroupWebModel> {

	@Override
	public GroupWebModel apply(Group input) {
		GroupWebModel output = new GroupWebModel();
		output.setId(input.getId());
		output.setTrainerId(input.getUser().getId());
		output.setName(input.getName());
		return output;
	}

}
