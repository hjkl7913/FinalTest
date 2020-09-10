package com.cos.baseball.repository;

import java.util.List;

import com.cos.baseball.model.Player;
import com.cos.baseball.model.dto.PlayerDto;
import com.cos.baseball.model.dto.PlayerPositionDto;

public interface PlayerRepository {
	public void PlayerSave(Player player);
	public void playerDeleteById(int id);
	public List<PlayerPositionDto> playerPositionAll();
	public List<PlayerDto> playerListAll();
}
