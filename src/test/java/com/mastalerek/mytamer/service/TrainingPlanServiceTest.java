package com.mastalerek.mytamer.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.builder.StudentTrainingPlanBuilder;
import com.mastalerek.mytamer.builder.TrainingPlanBasicWebModelBuilder;
import com.mastalerek.mytamer.builder.TrainingPlanBuilder;
import com.mastalerek.mytamer.entity.Student;
import com.mastalerek.mytamer.entity.StudentTrainingPlan;
import com.mastalerek.mytamer.functions.StudentTrainingPlansToTrainingPlanBasicWebModelFunction;
import com.mastalerek.mytamer.repository.StudentTrainingPlanRepository;
import com.mastalerek.mytamer.webmodel.TrainingPlanBasicWebModel;

public class TrainingPlanServiceTest {

	private static final String TRAINING_PLAN_NAME_2 = "tp2";
	private static final String TRAINING_PLAN_NAME_1 = "tp1";

	@Mock
	private StudentTrainingPlanRepository studentTrainingPlanRepository;
	@Mock
	private StudentTrainingPlansToTrainingPlanBasicWebModelFunction studentTrainingPlansToTrainingPlanBasicWebModelFunction;
	@InjectMocks
	private TrainingPlanService tested;

	@Before
	public void before() {
		tested = new TrainingPlanService();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldGetTrainingPlanNames() {
		// given
		Integer studentId = 65;
		StudentTrainingPlan plan1 = new StudentTrainingPlanBuilder().withId(11)
				.withTrainingPlan(new TrainingPlanBuilder().withName(TRAINING_PLAN_NAME_1).build())
				.withStudent(new Student()).build();
		StudentTrainingPlan plan2 = new StudentTrainingPlanBuilder().withId(12)
				.withTrainingPlan(new TrainingPlanBuilder().withName(TRAINING_PLAN_NAME_2).build())
				.withStudent(new Student()).build();
		TrainingPlanBasicWebModel tpModel1 = new TrainingPlanBasicWebModelBuilder().withName(TRAINING_PLAN_NAME_1)
				.build();
		TrainingPlanBasicWebModel tpModel2 = new TrainingPlanBasicWebModelBuilder().withName(TRAINING_PLAN_NAME_2)
				.build();
		when(studentTrainingPlanRepository.findByStudentId(eq(studentId))).thenReturn(Lists.newArrayList(plan1, plan2));
		when(studentTrainingPlansToTrainingPlanBasicWebModelFunction.apply(eq(plan1))).thenReturn(tpModel1);
		when(studentTrainingPlansToTrainingPlanBasicWebModelFunction.apply(eq(plan2))).thenReturn(tpModel2);
		// when
		List<TrainingPlanBasicWebModel> actual = tested.getTrainingPlanNames(studentId);
		// then
		assertThat(actual).hasSize(2);
		assertThat(actual.get(0).getName()).isEqualTo(TRAINING_PLAN_NAME_1);
		assertThat(actual.get(1).getName()).isEqualTo(TRAINING_PLAN_NAME_2);
	}
}
