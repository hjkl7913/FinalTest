package com.cos.baseball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.model.OutPlayer;
import com.cos.baseball.model.PlayGround;
import com.cos.baseball.model.Player;
import com.cos.baseball.model.Team;
import com.cos.baseball.model.dto.PlayGroundDto;
import com.cos.baseball.model.dto.PlayerDto;
import com.cos.baseball.model.dto.PlayerPositionDto;
import com.cos.baseball.model.dto.TeamDto;
import com.cos.baseball.model.dto.TeamPlayerOutDto;
import com.cos.baseball.repository.OutRepository;
import com.cos.baseball.repository.PlayerRepository;

@Service
public class OutService {
	
	@Autowired
	private OutRepository outRepository;
	
	@Transactional
	public void playerOutSaveProc(OutPlayer outPlayer) {
		outRepository.playerOutSave(outPlayer);
	}
	
	@Transactional(readOnly = true)
	public Player playerOutProcFindById(int id) {
		 return outRepository.playerOutFindById(id);
	}
	
	@Transactional(readOnly = true)
	public List<TeamPlayerOutDto> teamPlayerOutListProcFindByName(String teamName) {
		 return outRepository.teamPlayerOutListFindByName(teamName);
	}
}
