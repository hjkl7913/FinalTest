package com.cos.baseball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.model.Player;
import com.cos.baseball.model.dto.PlayerDto;
import com.cos.baseball.model.dto.PlayerPositionDto;
import com.cos.baseball.repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	

	@Transactional
	public void PlayerdSaveProc(Player player) {
		playerRepository.PlayerSave(player);
	}
	
	
	@Transactional(readOnly = true)
	public List<PlayerPositionDto> playerPositionAllProc() {
		 return playerRepository.playerPositionAll();
	}
	
	
	
	@Transactional(readOnly = true)
	public List<PlayerDto> playerListAllProc() {
		 return playerRepository.playerListAll();
	}
	
	
	
	@Transactional
	public void playerDeleteByIdProc(int id) {
		playerRepository.playerDeleteById(id);
	}
	
	
}
