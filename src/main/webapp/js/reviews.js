var rootURL = "http://localhost:8080/webapi";

$(function() {
	findAllReviews(1, '');
	welcomeToReviewsPage();
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
					query, page, 10);
		}
	});
}

function welcomeToReviewsPage() {
	var position = document.cookie.indexOf("username=");
   	if (position != -1) {
   		var start = position + 9;
   		var end = document.cookie.indexOf(";", start); 
   		if(end == -1) { 
   			end = document.cookie.length;
   		} 
    	user = unescape(document.cookie.substring(start, end));
    	document.getElementById("listReviews").innerHTML = 'Welcome to the reviews page, ' + user + '.';
   } 
}

function searchReviews() {
	var query = $('#search').val();
	findAllReviews(1, query);
}