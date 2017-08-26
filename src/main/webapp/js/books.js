var rootURL = "http://localhost:8080/webapi";

$(function() {
	findAllBooks(1, '');
});

function findAllBooks(page, query) {
	if (page == 0)
		page = 1;
	var booksURL = rootURL + '/books';
	$.ajax({
		type : 'GET',
		url : booksURL + '?query=' + query + '&page=' + page,
		dataType : "json",
		success : function(result) {
			var maxResults = result.pagination.maxResults;
			var books = result.data;
			$('#tBooks').empty();
			$.each(books, function(index, book) {
				$('#tBooks').append(
						'<tr><td>' + book.title + '</td><td>'
								+ book.releaseYear + '</td></tr>');
			});
			generatePagination('#pagination', 'findAllBooks', maxResults,
					query, page, 10);
		}
	});
}

function searchBooks() {
	var query = $('#search').val();
	findAllBooks(1, query);
}
