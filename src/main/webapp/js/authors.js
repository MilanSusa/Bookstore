var rootURL = "http://localhost:8080/rest/webapi";

$(function() {
	findAllAuthors();
});

function findAllAuthors() {
	$.ajax({
		type : 'GET',
		url : rootURL + '/authors',
		dataType : "json",
		success : function(result) {
			var maxResults = result.pagination.maxResults;
			var authors = result.data;
			$.each(authors, function(index, author) {
				$('#tAuthors').append(
						'<tr><td>' + author.id + '</td><td>' + author.firstName
								+ '</td><td>' + author.lastName + '</td><td>'
								+ author.gender + '</td></tr>');
			});
		}
	});
}