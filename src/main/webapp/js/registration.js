function executeSubmit() {	
	var registrationURL = "http://localhost:8080/webapi/registration"; 
	var user = {
		name: document.getElementById("name").value,
		username: document.getElementById("username").value,
		password: document.getElementById("password").value,
		email: document.getElementById("email").value
	};
	$.ajax({
		type: "POST",
		url: registrationURL,
    	data: JSON.stringify(user),
    	contentType: "application/json",
    	success : function(user) {
    		alert("Registration sent.") 
    	}
	});
}