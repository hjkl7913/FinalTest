package com.cos.baseball.model.dto;

import java.sql.Timestamp;

import com.cos.baseball.model.Player;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayerDto {
	private int no;
	private int id;
	private String teamName;
	private String playerName;
	private String position;
	private Timestamp create_date;
}
