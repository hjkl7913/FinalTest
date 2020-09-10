
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
				groundName: $("#groundName").val(),
		};
		
		console.log(data);
		
		$.ajax({
			type: "POST",
			url: "/playgroundProc",
			data: JSON.stringify(data), // json 으로 바꿔줌
			contentType: "application/json; charset=utf-8", 
			dataType: "json"
			
		}).done(function(resp){
			 console.log(resp); 
				alert("등록 성공");
		}).fail(function(error){
			alert("등록 실패");
			console.log(error);
		})
	}
	
}

function playGroundDelete(id) {
	$.ajax({
		type: "DELETE",
		url: "/playGroundDelete/"+id,
		dataType: "json"
		
	}).done(function(resp){
		 console.log(resp); 
		 $(".playground-list").empty();
		renderPlaygroundListAll(resp);
		//alert("삭제 성공");
		//location.href="/playgroundList";
	}).fail(function(error){
		alert("삭제 실패");
		console.log(error);
	});
}


function renderPlaygroundListAll(resp){
	for(var res of resp){
		$(".playground-list").append(makeGroundItemAll(res));
	}
}


function makeGroundItemAll(res){
	var groundItem = `<tr>`;
	groundItem += `<td>${res.no}</td>`;
	groundItem += `<td>${res.groundName}</td>`;
	groundItem += `<td>${res.create_date}</td>`;
	groundItem += `<td><button class="btn btn-success" onclick="playGroundDelete('${res.id}')">삭제</button></td>`;
	groundItem += `</tr>`;
	
	return groundItem;
}


index.init();