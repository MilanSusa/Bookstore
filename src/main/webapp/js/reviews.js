var rootURL = "http://localhost:8080/rest/webapi";

$(function() {
	findAllReviews(1, '');
});

function findAllReviews(page, query) {
	if (page == 0)
		page = 1;
	var reviewsURL = rootURL + '/reviews';
	$.ajax({
		type : 'GET',
		url : reviewsURL + '?query=' + query + '&page=' + page,
		dataType : "json",
		success : function(result) {
			var maxResults = result.pagination.maxResults;
			var reviews = result.data;
			$('#tReviews').empty();
			$.each(reviews, function(index, review) {
				$('#tReviews').append(
						'<tr><td>' + review.reviewerFirstName + '</td><td>'
								+ review.reviewerLastName + '</td><td>'
								+ review.rank + '</td><td>' + review.created
								+ '</td></tr>');
			});
			generatePagination('#pagination', 'findAllReviews', maxResults,
					query, page, 1);
		}
	});
}

function searchReviews() {
	var query = $('#search').val();
	findAllReviews(1, query);
}