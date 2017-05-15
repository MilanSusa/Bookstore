var rootURL = "http://localhost:8080/webapi";

$(function() {
	findAllBooks('', 1);
});

function findAllBooks(query, page) {
	if (!page) page = 1;
	
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
								'<tr><td>' + book.id + '</td><td>' + book.title
										+ '</td><td>' + book.releaseYear
										+ '<td/></tr>');
			});
			
			generatePagination('#pagination', 'findAllBooks', query, maxResults, page, 1);
		}
	});
}

function searchBooks() {
	var query = $('#search').val();
	findAllBooks(query, 1);
}
