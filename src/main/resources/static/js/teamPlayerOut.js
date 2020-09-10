

function teamPlayerOutList(teamName) {
	
	$.ajax({
		type: "GET",
		url: "/teamPlayerOutList/"+teamName,
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		 
		 //db 에서 넘어온 null 값을 "" 공백처리
		 var resps = JSON.parse(JSON.stringify(resp).replace(/\:null/gi, "\:\"\""));
		 console.log(resps); 
		 
		$(".team-player-out-list").empty();
		renderTeamPlayerOutList(resps);
	}).fail(function(error){
		alert("불러오기 실패");
		console.log(error);
	});
}


function renderTeamPlayerOutList(resps){
	for(var res of resps){
		$(".team-player-out-list").append(makeTeamPlayerOutList(res));
	}
}


function makeTeamPlayerOutList(res){

	var playItem = `<tr>`;
	playItem += `<td>${res.playerId}</td>`;
	playItem += `<td>${res.playerName}</td>`;
	playItem += `<td>${res.position}</td>`;
	playItem += `<td>${res.reason}</td>`;
	playItem += `<td>${res.outDate}</td>`;
	playItem += `</tr>`;
	
	return playItem;
}
