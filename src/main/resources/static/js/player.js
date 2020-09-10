
let index = {
		
	init: function(){
	
		$("#btn-save").on("click", ()=>{
			// _this.save();
			
			// 콜백 스택
			this.save();
		});
		
		$("#btn-playerOut-save").on("click", ()=>{
			// _this.save();
			
			// 콜백 스택
			this.playerOutSave();
		});
			
	},
	
	
	save: function(){
		let data = {
				teamName: $("#teamName option:selected").val(),
				playerName: $("#playerName").val(),
				position: $("#position").val()
				
		};
		
		console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/playerProc",
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			 console.log(resp.statusCode); 
			 if(resp.statusCode == 0){
				 alert("존재 하지않는 팀이름 입니다.");
			 } else{
				 alert("등록 성공");
			 }
				location.href="/playerSave";
		}).fail(function(error){
			alert("등록 실패");
			console.log(error);
		})
	},
	
	playerOutSave: function(){
		let data = {
				playerName: $("#playerName").val(),
				playerId: $("#id").val(),
				reason: $("#reason").val(),
				out_date: $("#out_date").val()
		};
		
		console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/playerOutSaveProc",
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			 console.log(resp.statusCode); 
				alert("등록 성공");
				location.href="/playerListO";
		}).fail(function(error){
			alert("등록 실패");
			console.log(error);
		})
	}
	
}

function playerDelete(id) {
	$.ajax({
		type: "DELETE",
		url: "/playerDelete/"+id,
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		 $(".player-list").empty();
		renderPlayerListAll(resp);
		//alert("삭제 성공");
		//location.href="/playgroundList";
	}).fail(function(error){
		alert("삭제 실패");
		console.log(error);
	});
}


function renderPlayerListAll(resp){
	for(var res of resp){
		$(".player-list").append(makePlayerItemAll(res));
	}
}


function makePlayerItemAll(res){
	var playItem = `<tr>`;
	playItem += `<td>${res.no}</td>`;
	playItem += `<td>${res.teamName}</td>`;
	playItem += `<td>${res.playerName}</td>`;
	playItem += `<td>${res.position}</td>`;
	playItem += `<td><button class="btn btn-success" onclick="playerDelete('${res.id}')">삭제</button></td>`;
	playItem += `</tr>`;
	
	return playItem;
}

function playerOutProc(id){
	location.href="/playerOutProc/"+id;
}

index.init();