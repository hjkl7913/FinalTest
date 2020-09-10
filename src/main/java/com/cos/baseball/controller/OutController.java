package com.cos.baseball.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.controller.dto.CommonRespDto;
import com.cos.baseball.model.OutPlayer;
import com.cos.baseball.model.dto.TeamPlayerOutDto;
import com.cos.baseball.service.OutService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class OutController {
	
	private final OutService outService;
	
	@GetMapping("/teamPlayerOut")
	public String teamPlayerOut() {
		return "/page/teamPlayerOut";
	}
	
	@GetMapping("/playerOut")
	public String playerOut() {
		return "/page/playerOut";
	}
	
	@GetMapping("/playerOutProc/{id}")
	public String playerOutProc(@PathVariable int id, Model model) {
		model.addAttribute("playerOutProc",outService.playerOutProcFindById(id));
		System.out.println("playerOutProc : model : "+model);
		return "/page/playerOut";
	}
	
	@PostMapping("/playerOutSaveProc")
	public @ResponseBody CommonRespDto<?> playerOutSaveProc(@RequestBody OutPlayer outPlayer) {
		outService.playerOutSaveProc(outPlayer);
		return new CommonRespDto<String>(1, "등록 성공");
	}
	
	@GetMapping("/teamPlayerOutList/{teamName}")
	public @ResponseBody String teamPlayerOutListProc(@PathVariable String teamName) {
		List<TeamPlayerOutDto> teamPlayerOutDtos = outService.teamPlayerOutListProcFindByName(teamName);
		
		System.out.println("teamPlayerOutDtos : "+teamPlayerOutDtos);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = "";
		try {
			jsonList = mapper.writeValueAsString(teamPlayerOutDtos);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonList;
	}
	
	
}
