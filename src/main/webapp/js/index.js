 $(function() {
	var position = document.cookie.indexOf("username=");
	if (position != -1) {
		var start = position + 9;
		var end = document.cookie.indexOf(";", start); 
		if(end == -1) { 
			end = document.cookie.length;
		} 
		var email = unescape(document.cookie.substring(start, end));
	}

	var rootURL = "http://localhost:8080/webapi/registration/";
	$.ajax({
		type : "GET",
		url : rootURL + email,
		dataType : "json",
		success : function(user) {
			document.getElementById("Dashboard").innerHTML = 'Welcome to dashboard, ' + user.name + '.';
		}
	});
});



