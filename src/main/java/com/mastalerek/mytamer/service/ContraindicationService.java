package com.mastalerek.mytamer.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mastalerek.mytamer.entity.Contraindication;
import com.mastalerek.mytamer.repository.ContraindicationRepository;

@Component
public class ContraindicationService {
	@Inject
	private ContraindicationRepository contraindicationRepository;

	public List<String> getStudentContraindications(Integer studentId) {
		List<String> output = Lists.newArrayList();
		List<Contraindication> contraindications = contraindicationRepository.findByStudentId(studentId);
		for (Contraindication contraindication : contraindications) {
			output.add(contraindication.getText());
		}
		return output;
	}

}
