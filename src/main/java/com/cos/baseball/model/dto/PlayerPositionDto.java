package com.cos.baseball.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerPositionDto {
	private String playerName;
	private String position;
	private String t1;
	private String t2;
	private String t3;
}
