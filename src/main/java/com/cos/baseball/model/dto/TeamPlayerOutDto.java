package com.cos.baseball.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamPlayerOutDto {
	private int playerId;
	private String playerName;
	private String position;
	private String reason;
	private String outDate;
}
