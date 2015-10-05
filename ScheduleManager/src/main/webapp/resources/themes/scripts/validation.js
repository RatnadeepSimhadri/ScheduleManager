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

function searchScheduleDetails(){
	$("#searchSchedule").submit();
}

function loadCreateLabProfile(){
	$("#loadCreateLabProfile").submit();
	
}

function saveProfile(){
	
	$("#createProfile").submit();
}

function saveLabProfile(){
	$("#createLabProfile").submit();
}

function loadAssignShift(){
	$("#loadAssignShift").submit();
}

function configureShifts(){
	$("#configureShifts").submit();
}

function saveShifts(){
	
	var size = $('#size').val();
	for(i=1;i<=size;i++){
	var id = document.getElementById('employee_'+i+'shift_'+i).value;	
	$('#saveShifts').append('<input type="hidden" name="shift'+i+'" value="'+id+'" />');
	}
	
	$('#saveShifts').append('<input type="hidden" name="size" value="'+size+'" />');
	$('#saveShifts').submit();
}

function callback(resp){
	
	if(resp !=null || resp !=""){
	$("#search").html(resp);
	}
}

