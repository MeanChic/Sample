function checkForm(form){ 
	
}

function selectForm(form){
	
}

function deleteCheck(addrForm, root){
	var url=root + "/address/deleteOk.do?name=" + addrForm.name.value;
	
	var value=confirm("정말로 삭제하시겟습니까?");
	
	if(value==true){
		$(location).attr("href", url);
	}else{
		alert("삭제 되지 않았습니다.");
	}
}