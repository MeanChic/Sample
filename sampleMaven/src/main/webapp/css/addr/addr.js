function checkForm(form){   }

function selectForm(form){
	alert("OK");
}

function deleteCheck(addrForm, root){
	//alert("OK");
	var url=root + "/addr/deleteOk.do?name=" + addrForm.name.value;
	//alert(url);
	var value=confirm("정말로 삭제하시겠습니까?");
	if(value == true){
		location.href=url;
	}else{
		alert("삭제 되지 않았습니다.");
	}
}