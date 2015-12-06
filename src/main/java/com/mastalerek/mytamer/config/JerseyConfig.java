package com.mastalerek.mytamer.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.webapi.impl.DisciplineWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.ExerciseSetWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.ExerciseUnitWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.ExerciseWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.GroupWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.MeasurementWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.RankWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.StudentWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.UserWebApiImpl;

@Component
@ApplicationPath(JerseyConfig.APPLICATION_PATH)
public class JerseyConfig extends ResourceConfig {
	static final String APPLICATION_PATH = "/mytamer";

	public JerseyConfig() {
		register(UserWebApiImpl.class);
		register(GroupWebApiImpl.class);
		register(RankWebApiImpl.class);
		register(StudentWebApiImpl.class);
		register(MeasurementWebApiImpl.class);
		register(DisciplineWebApiImpl.class);
		register(ExerciseUnitWebApiImpl.class);
		register(ExerciseWebApiImpl.class);
		register(ExerciseSetWebApiImpl.class);
	}
}
