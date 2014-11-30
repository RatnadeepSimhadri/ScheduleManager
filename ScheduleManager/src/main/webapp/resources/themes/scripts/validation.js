function validateLogin(){
	var username = $("#username").val();
	var password =$("#password").val();
	
	if(username== null || username ==""){
		alert("User Name cannot be Empty");
		return;
	}
	if(password== null || password ==""){
		alert("Password cannot be Empty");
		return;
	}
	
	$("#login").submit();
}

function loadPage(url){
	
	var url=url;
	var resp = "";
    var formMethod = "POST";
	var paramList = {
			url: url,
			type: formMethod,
			data: null,	
			async: false,
			success: function(response){
				resp = response;
				callback(resp);
			},
			error: function(event) {
				alert("Error in retrieving responce. Please try again!");
				resp = "";
			}
		};
	var callRequest = $.ajax(paramList);
}

function loadCreateProfile(){
	$("#loadCreateProfile").submit();
	
}

function saveProfile(){
	$("#createProfile").submit();
}

function loadAssignShift(){
	$("#loadAssignShift").submit();
}

function saveShifts(){
		
	$('#saveShifts').append('<input type="hidden" name="token" value="1" />');
	$('#saveShifts').submit();
}

function callback(resp){
	
	if(resp !=null || resp !=""){
	$("#search").html(resp);
	}
}