package com.cos.baseball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.model.PlayGround;
import com.cos.baseball.model.dto.PlayGroundDto;
import com.cos.baseball.repository.PlayGroundRepository;

@Service
public class PlayGroundService {
	
	@Autowired
	private PlayGroundRepository playGroundRepository;
	
	
	@Transactional
	public void PlaygroundSaveProc(PlayGround playGound) {
		playGroundRepository.PlaygroundSave(playGound);
	}
	
	@Transactional(readOnly = true)
	public List<PlayGroundDto> playgroundListAllProc() {
		 return playGroundRepository.playgroundListAll();
	}
	
	
	@Transactional
	public void playGroundDeleteByIdProc(int id) {
		playGroundRepository.playGroundDeleteById(id);
	}
	
	@Transactional(readOnly = true)
	public PlayGround playgroundFindByName(String groundName) {
		 return playGroundRepository.groundFindByName(groundName);
	}
	
}
