package com.cos.baseball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.model.Team;
import com.cos.baseball.model.dto.TeamDto;
import com.cos.baseball.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Transactional
	public void TeamSaveProc(Team team) {
		teamRepository.TeamSave(team);
	}
	
	@Transactional(readOnly = true)
	public List<TeamDto> teamListAllProc() {
		 return teamRepository.teamListAll();
	}
	
	@Transactional
	public void teamDeleteByIdProc(int id) {
		teamRepository.teamDeleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Team TeamFindByGroundId(String groundId) {
		 return teamRepository.TeamFindByGId(groundId);
	}
	
	@Transactional(readOnly = true)
	public Team TeamFindByTempTeamName(String tempTeamName) {
		 return teamRepository.TeamFindByTTeamName(tempTeamName);
	}
	
}
