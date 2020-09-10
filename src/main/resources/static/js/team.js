
let index = {
		
	init: function(){
	
		$("#btn-save").on("click", ()=>{
			// _this.save();
			
			// 콜백 스택
			this.save();
		});
			
	},
	
	
	save: function(){
		

		let data = {
				
				groundId: $("#groundId option:selected").val(),
				teamName: $("#teamName").val()
		};
		
		console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/teamNameProc",
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			 console.log(resp); 
				alert("등록 성공");
				location.href="/teamSave";
		}).fail(function(error){
			alert("등록 실패");
			console.log(error);
		})
	}
	
}


function teamDelete(id) {
	$.ajax({
		type: "DELETE",
		url: "/teamDelete/"+id,
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		 alert("삭제 성공");
		 $(".team-list").empty();
		renderTeamListAll(resp);
		
		//location.href="/playgroundList";
	}).fail(function(error){
		alert("삭제 실패");
		console.log(error);
	});
}


function renderTeamListAll(resp){
	for(var res of resp){
		$(".team-list").append(makeTeamItemAll(res));
	}
}


function makeTeamItemAll(res){
	var teamItem = `<tr>`;
	teamItem += `<td>${res.no}</td>`;
	teamItem += `<td>${res.groundId}</td>`;
	teamItem += `<td>${res.teamName}</td>`;
	teamItem += `<td><button class="btn btn-success" onclick="teamDelete('${res.id}')">삭제</button></td>`;
	teamItem += `</tr>`;
	
	return teamItem;
}

index.init();