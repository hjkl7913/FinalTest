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
public class OutPlayer {
	private int id;
	private int playerId;
	private String playerName;
	private String reason;
	private String out_date;
}
