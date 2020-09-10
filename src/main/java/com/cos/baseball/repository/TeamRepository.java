package com.cos.baseball.repository;

import java.util.List;

import com.cos.baseball.model.Team;
import com.cos.baseball.model.dto.TeamDto;

public interface TeamRepository {
	public void TeamSave(Team team);
	public void teamDeleteById(int id);
	public Team TeamFindByGId(String groundId);
	public Team TeamFindByTTeamName(String tempTeamName);
	public List<TeamDto> teamListAll();
}
