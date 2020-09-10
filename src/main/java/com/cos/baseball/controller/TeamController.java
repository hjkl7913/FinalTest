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
import com.cos.baseball.model.Team;
import com.cos.baseball.model.dto.PlayGroundDto;
import com.cos.baseball.model.dto.TeamDto;
import com.cos.baseball.service.PlayGroundService;
import com.cos.baseball.service.TeamService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TeamController {
	
	private final TeamService teamService;
	private final PlayGroundService playGroundService;
	
	
	@PostMapping("/teamNameProc")
	public @ResponseBody CommonRespDto<?> teamNameProc(@RequestBody Team team) {
		teamService.TeamSaveProc(team);
		return new CommonRespDto<String>(1, "등록 성공");
	}
	
	@GetMapping("/teamList")
	public String teamList(Model model) {
		List<TeamDto> teamList = teamService.teamListAllProc();
		model.addAttribute("teamLists", teamList);
		System.out.println("teamList : model : "+model);
		return "/page/teamList";
	}
	
	
	
	
	
	@DeleteMapping("/teamDelete/{id}")
	public @ResponseBody String playGroundDelete(@PathVariable int id) {
		
		teamService.teamDeleteByIdProc(id);
		List<TeamDto> teamList = teamService.teamListAllProc();
		System.out.println("teamList : "+teamList);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = "";
		try {
			jsonList = mapper.writeValueAsString(teamList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonList;
	}
	
	@GetMapping("/teamSave")
	public String teamSave(Model model) {
		List<PlayGroundDto> playgroundList  = playGroundService.playgroundListAllProc();
		model.addAttribute("playgrounds", playgroundList);
		System.out.println("model : "+model);
		return "/page/teamSaveForm";
	}
	
	
}
