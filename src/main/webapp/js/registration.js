function executeSubmit() {
	var registrationURL = "http://localhost:8080/webapi/registration";
	var user = {
		name : document.getElementById("name").value,
		email : document.getElementById("email").value,
		password : document.getElementById("password").value
	};
	$.ajax({
		type : "POST",
		url : registrationURL,
		data : JSON.stringify(user),
		contentType : "application/json",
		success : function() {
			alert("Registration sent.")
		}
	});
}