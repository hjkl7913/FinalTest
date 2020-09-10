package com.cos.baseball.repository;

import java.util.List;

import com.cos.baseball.model.OutPlayer;
import com.cos.baseball.model.Player;
import com.cos.baseball.model.dto.TeamPlayerOutDto;

public interface OutRepository {
	public Player playerOutFindById(int id);
	public List<TeamPlayerOutDto> teamPlayerOutListFindByName(String out);
	public void playerOutSave(OutPlayer outPlayer);
}
