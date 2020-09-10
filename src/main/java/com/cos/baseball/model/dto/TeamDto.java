package com.cos.baseball.model.dto;

import com.cos.baseball.model.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDto {
	private int no;
	private Team team;
}
