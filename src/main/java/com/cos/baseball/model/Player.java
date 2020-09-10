package com.cos.baseball.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
	private int id;
	private int teamId;
	private String teamName;
	private String playerName;
	private String position;
	private Timestamp create_date;
}
