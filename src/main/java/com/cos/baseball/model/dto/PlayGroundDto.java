package com.cos.baseball.model.dto;

import java.sql.Timestamp;
import java.util.List;

import com.cos.baseball.model.PlayGround;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayGroundDto {
	private int no;
	// int id;
	//private String groundName;
	//private Timestamp create_date;
	private PlayGround playGround;
}
