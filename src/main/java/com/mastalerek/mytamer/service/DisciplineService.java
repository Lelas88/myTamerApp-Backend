package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.Discipline;
import com.mastalerek.mytamer.functions.DisciplineToDisciplineWebModelFunction;
import com.mastalerek.mytamer.repository.DisciplineRepository;
import com.mastalerek.mytamer.webmodel.DisciplineWebModel;

@Component
public class DisciplineService {
	
	@Inject
	private DisciplineRepository disciplineRepository;
	@Inject
	private DisciplineToDisciplineWebModelFunction disciplineToDisciplineWebModelFunction;
	
	public List<DisciplineWebModel> getAllDisciplines() {
		List<Discipline> disciplinesList = (List<Discipline>) disciplineRepository.findAll();
		return disciplineToDisciplineWebModelFunction.apply(disciplinesList);
	}

	public void createDiscipline(DisciplineWebModel disciplineWebModel) {
		Discipline discipline = new Discipline();
		saveDiscipline(disciplineWebModel, discipline);
	}

	public void updateDiscipline(DisciplineWebModel disciplineWebModel) {
		Discipline discipline = disciplineRepository.findOne(disciplineWebModel.getId());
		saveDiscipline(disciplineWebModel, discipline);
	}

	private void saveDiscipline(DisciplineWebModel disciplineWebModel, Discipline discipline) {
		discipline.setName(disciplineWebModel.getName());
		discipline.setDescription(disciplineWebModel.getDescription());
		discipline.setIconName(discipline.getIconName());
		disciplineRepository.save(discipline);
	}

}
