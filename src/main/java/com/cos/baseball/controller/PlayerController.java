package com.cos.baseball.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.controller.dto.CommonRespDto;
import com.cos.baseball.model.Player;
import com.cos.baseball.model.Team;
import com.cos.baseball.model.dto.PlayerDto;
import com.cos.baseball.model.dto.PlayerPositionDto;
import com.cos.baseball.model.dto.TeamDto;
import com.cos.baseball.service.PlayerService;
import com.cos.baseball.service.TeamService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PlayerController {
	
	private final PlayerService playerService;
	private final TeamService teamService;
	
	@GetMapping("/playerSave")
	public String playerSave(Model model) {
		List<TeamDto> teamList = teamService.teamListAllProc();
		model.addAttribute("teamLists", teamList);
		System.out.println("model : "+model);
		return "/page/playerSaveForm";
	}
	

//	@GetMapping("/playerSave/{groundId}")
//	public String playerSave(@PathVariable String groundId, Model model) {
//		model.addAttribute("Team",baseballService.TeamFindByGroundId(groundId));
//		System.out.println("model : "+model);
//		return "/page/playerSaveForm";
//	}
	
	@PostMapping("/playerProc")
	public @ResponseBody CommonRespDto<?> playerProc(@RequestBody Player player) {
		String tempTeamName = player.getTeamName();
		System.out.println("tempTeamName : "+tempTeamName);
		
		Team team = teamService.TeamFindByTempTeamName(tempTeamName);
		System.out.println("team : "+team);
		
		if(team == null) {
			return new CommonRespDto<String>(0, "팀 존재 x");
		} else {
			player.setTeamId(team.getId());
			player.setTeamName(team.getTeamName());
			playerService.PlayerdSaveProc(player);
		}
		
		return new CommonRespDto<String>(1, "등록 성공");
	}
	
	
	@GetMapping("/playerPosition")
	public String playerPosition(Model model) {
		List<PlayerPositionDto> playerPosition = playerService.playerPositionAllProc();
		model.addAttribute("playerPositions", playerPosition);
		System.out.println("playerPosition : model : "+model);
		return "/page/playerPosition";
	}
	
	
	@GetMapping("/playerList")
	public String playerList(Model model, Model teamModel) {
		List<PlayerDto> playerList = playerService.playerListAllProc();
		
		model.addAttribute("playerLists", playerList);
		System.out.println("playerList : model : "+model);
		return "/page/playerList";
	}
	
	

	@DeleteMapping("/playerDelete/{id}")
	public @ResponseBody String playerDelete(@PathVariable int id) {
		playerService.playerDeleteByIdProc(id);
		List<PlayerDto> playerList = playerService.playerListAllProc();
		System.out.println("playerList : "+playerList);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = "";
		try {
			jsonList = mapper.writeValueAsString(playerList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonList;
	}
	
	@GetMapping("/playerListO")
	public String playerListO(Model model) {
		List<PlayerDto> playerList = playerService.playerListAllProc();
		
		model.addAttribute("playerLists", playerList);
		System.out.println("playerList : model : "+model);
		
		return "/page/playerListO";
	}
	
	
}
