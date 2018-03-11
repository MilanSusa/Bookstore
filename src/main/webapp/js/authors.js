var rootURL = "http://localhost:8080/webapi";

$(function() {
	findAllAuthors(1, '');
	welcomeToAuthorsPage();
});

function findAllAuthors(page, query) {
	if (page == 0)
		page = 1;
	var authorsURL = rootURL + '/authors';
	$.ajax({
		type : 'GET',
		url : authorsURL + '?query=' + query + '&page=' + page,
		dataType : "json",
		success : function(result) {
			var maxResults = result.pagination.maxResults;
			var authors = result.data;
			$('#tAuthors').empty();
			$.each(authors, function(index, author) {
				$('#tAuthors').append(
						'<tr><td>' + author.firstName + '</td><td>'
								+ author.lastName + '</td></tr>');
			});
			generatePagination('#pagination', 'findAllAuthors', maxResults,
					query, page, 10);
		}
	});
}

function welcomeToAuthorsPage() {
	var position = document.cookie.indexOf("username=");
	if (position != -1) {
		var start = position + 9;
		var end = document.cookie.indexOf(";", start);
		if (end == -1) {
			end = document.cookie.length;
		}
		user = unescape(document.cookie.substring(start, end));
		document.getElementById("listAuthors").innerHTML = 'Welcome to the authors page, '
				+ user + '.';
	}
}

function searchAuthors() {
	var query = $('#search').val();
	findAllAuthors(1, query);
}

function executeSearch(inputField) {
	var $this = this;
	var delayedSearch = function() {
		findAllAuthors(1, $(inputField).val());
	};
	window.clearTimeout(this.keystrokeTimeout);
	this.keystrokeTimeout = window.setTimeout(delayedSearch, 250);
}
