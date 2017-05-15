var rootURL = "http://localhost:8080/rest/webapi";

$(function() {
	findAllReviews();
});

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
