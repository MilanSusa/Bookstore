var rootURL = "http://localhost:8080/rest/webapi";

$(function() {
	findAllAuthors();
	findAllBooks();
	findAllReviews();
});

function findAllAuthors() {
	$.ajax({
		type : 'GET',
		url : rootURL + '/authors',
		dataType : "json",
		success : function(result) {
			// var maxResults = result.pagination.maxResults;
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

function findAllBooks() {
	$.ajax({
		type : 'GET',
		url : rootURL + '/books',
		dataType : "json",
		success : function(result) {
			// var maxResults = result.pagination.maxResults;
			var books = result.data;
			$.each(books, function(index, book) {
				$('#tBooks')
						.append(
								'<tr><td>' + book.id + '</td><td>' + book.title
										+ '</td><td>' + book.releaseYear
										+ '<td/></tr>');
			});
		}
	});
}

function findAllReviews() {
	$.ajax({
		type : 'GET',
		url : rootURL + '/reviews',
		dataType : "json",
		success : function(result) {
			// var maxResults = result.pagination.maxResults;
			var reviews = result.data;
			$.each(reviews, function(index, review) {
				$('#tReviews').append(
						'<tr><td>' + review.id + '</td><td>'
								+ review.reviewerFirstName + '</td><td>'
								+ review.reviewerLastName + '</td><td>'
								+ review.rank + '</td><td>' + review.created
								+ '</td></tr>');
			});
		}
	});
}
