package com.cos.baseball.repository;

import java.util.List;

import com.cos.baseball.model.PlayGround;
import com.cos.baseball.model.dto.PlayGroundDto;

public interface PlayGroundRepository {
	public PlayGround groundFindByName(String groundName);
	public List<PlayGroundDto> playgroundListAll();
	public void playGroundDeleteById(int id);
	public void PlaygroundSave(PlayGround playGound);
	
}
