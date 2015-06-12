<<<<<<< HEAD
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
=======
function checkForm(form){ 
	
}

function selectForm(form){
	
}

function deleteCheck(addrForm, root){
	var url=root + "/address/deleteOk.do?name=" + addrForm.name.value;
	
	var value=confirm("정말로 삭제하시겟습니까?");
	
	if(value==true){
		$(location).attr("href", url);
>>>>>>> branch 'master' of https://github.com/MeanChic/Sample.git
	}else{
		alert("삭제 되지 않았습니다.");
	}
}
