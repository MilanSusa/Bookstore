var rootURL = "http://localhost:8080/rest/webapi";
var currentAuthor, currentBook, currentReview;

$('#btnAuthors').click(function() {
	findAllAuthors();
});

$('#btnBooks').click(function() {
	findAllBooks();
});

$('#btnReviews').click(function() {
	findAllReviews();
});

function findAllAuthors() {
	$.ajax({
		type : 'GET',
		url : rootURL + '/authors',
		dataType : "json",
		success : function(authors) {
			$.each(authors, function(index, author) {
				$('#authors').append(
						'<li>' + author.id + author.firstName + author.lastName
								+ author.gender + '</li>');
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
			var maxResults = result.pagination.maxResults;
			
			var books = result.data;
			$.each(books, function(index, book) {
				$('#books').append(
						'<li>' + book.id + book.title + book.releaseYear
								+ '</li>');
			});
		}
	});
}

function findAllReviews() {
	$.ajax({
		type : 'GET',
		url : rootURL + '/reviews',
		dataType : "json",
		success : function(reviews) {
			$.each(reviews, function(index, review) {
				$('#reviews').append(
						'<li>' + review.id + review.reviewerFirstName
								+ review.reviewerlastName + review.rank
								+ review.created + '</li>');
			});
		}
	});
}
