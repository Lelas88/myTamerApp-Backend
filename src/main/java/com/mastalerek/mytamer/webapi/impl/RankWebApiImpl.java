package com.mastalerek.mytamer.webapi.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.mastalerek.mytamer.service.RankService;
import com.mastalerek.mytamer.webapi.RankWebApi;

@Component
public class RankWebApiImpl implements RankWebApi {

	@Inject
	private RankService rankService;

	@Override
	public String getRankById(Integer rankId) {
			return rankService.getRankById(rankId);
	}
}
