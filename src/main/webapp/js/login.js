function makeUsernameCookie() {
	var username = document.getElementById("username").value;
	var expires = new Date();
	expires.setMinutes(expires.getMinutes() + 5);
	document.cookie = "username = " + escape(username) + "; expires = "
			+ expires.toGMTString();
}
