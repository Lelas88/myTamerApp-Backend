package com.mastalerek.mytamer.service;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.entity.Rank;
import com.mastalerek.mytamer.repository.RankRepository;

@Component
public class RankService {

	@Inject
	private RankRepository rankRepository;

	public String getRankById(Integer rankId) {
		Rank rank = rankRepository.findOne(rankId);
		return rank.getName();
	}
}
