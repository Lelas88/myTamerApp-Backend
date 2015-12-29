package com.mastalerek.mytamer.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.webapi.impl.DietWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.DisciplineWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.ExerciseSetWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.ExerciseUnitWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.ExerciseWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.GroupWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.MealSetWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.MealWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.MeasurementWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.RankWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.StudentWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.TimesheetWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.TrainingPlanWebApiImpl;
import com.mastalerek.mytamer.webapi.impl.UserWebApiImpl;

@Component
@ApplicationPath(JerseyConfig.APPLICATION_PATH)
public class JerseyConfig extends ResourceConfig {
	static final String APPLICATION_PATH = "/mytamer";

	public JerseyConfig() {
		register(CORSResponseFilter.class);
		register(UserWebApiImpl.class);
		register(GroupWebApiImpl.class);
		register(RankWebApiImpl.class);
		register(StudentWebApiImpl.class);
		register(MeasurementWebApiImpl.class);
		register(DisciplineWebApiImpl.class);
		register(ExerciseUnitWebApiImpl.class);
		register(ExerciseWebApiImpl.class);
		register(TrainingPlanWebApiImpl.class);
		register(TimesheetWebApiImpl.class);
		register(ExerciseSetWebApiImpl.class);
		register(MealWebApiImpl.class);
		register(MealSetWebApiImpl.class);
		register(DietWebApiImpl.class);
	}
}
