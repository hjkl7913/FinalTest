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
import com.cos.baseball.model.PlayGround;
import com.cos.baseball.model.dto.PlayGroundDto;
import com.cos.baseball.service.PlayGroundService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PlayGroundController {
	
	private final PlayGroundService playGroundService;
	
	@GetMapping("/playgroundSave")
	public String playground() {
		return "/page/stardiumSaveForm";
	}
	
	@PostMapping("/playgroundProc")
	public @ResponseBody CommonRespDto<?> playgroundProc(@RequestBody PlayGround playGound) {
		playGroundService.PlaygroundSaveProc(playGound);
		return new CommonRespDto<String>(1, "등록 성공");
	}
	
	@GetMapping("/playgroundList")
	public String playgroundList(Model model) {
		List<PlayGroundDto> playgroundList  = playGroundService.playgroundListAllProc();
		model.addAttribute("playgrounds", playgroundList);
		System.out.println("playgroundList : model : "+model);
		return "/page/stardiumList";
	}
	
	@DeleteMapping("/playGroundDelete/{id}")
	public @ResponseBody String teamDelete(@PathVariable int id) {
		playGroundService.playGroundDeleteByIdProc(id);
		List<PlayGroundDto> playgroundList = playGroundService.playgroundListAllProc();
		System.out.println("playgroundList : "+playgroundList);
		ObjectMapper mapper = new ObjectMapper();
		String jsonList = "";
		try {
			jsonList = mapper.writeValueAsString(playgroundList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonList;
	}
	
	
	
//	@GetMapping("/teamSaveProc/{groundName}")
//	public String teamSaveProc(@PathVariable String groundName, Model model) {
//		model.addAttribute("PlayGround",playGroundService.playgroundFindByName(groundName));
//		System.out.println("model : "+model);
//		return "/page/teamSaveForm";
//	}
	

	
}
