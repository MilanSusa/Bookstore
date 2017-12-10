$(function() {
	var position = document.cookie.indexOf("username=");
	if (position != -1) {
		var start = position + 9;
		var end = document.cookie.indexOf(";", start); 
		if(end == -1) { 
			end = document.cookie.length;
		} 
		user = unescape(document.cookie.substring(start, end));
		document.getElementById("Dashboard").innerHTML = 'Welcome to dashboard, ' + user + '.';
	} 
});



