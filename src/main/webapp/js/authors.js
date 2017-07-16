var rootURL = "http://localhost:8080/webapi";

$(function() {
	findAllAuthors(1, '');
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

function searchAuthors() {
	var query = $('#search').val();
	findAllAuthors(1, query);
}