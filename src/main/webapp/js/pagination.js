function generatePagination(container, listFunction, maxResults, query, page, limit) {
	var pages = Math.floor(maxResults / limit);
	
	$(container).empty();
	// var prevClazz = (page-1) == 0 ? 'disabled' : '';
	
	if ((page-1) == 0) {
		$(container).append('<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>');
	} else {
		$(container).append('<li class="page-item"><a class="page-link" href="#" onclick="'+listFunction+'('+(page-1)+', '+ query + ')">Previous</a></li>');
	}
	
	for(var i=0; i<pages; i++) {
		var clazz = (page == (i+1)) ? 'active' : '';
		
		$(container).append('<li class="page-item '+clazz+'"><a class="page-link" href="#" onclick="'+listFunction+'('+(i+1)+', '+ query + ')">'+(i+1)+'</a></li>');
	}
	
	if (page == pages) {
		$(container).append('<li class="page-item disabled"><a class="page-link" href="#">Next</a></li>');
	} else {
		$(container).append('<li class="page-item"><a class="page-link" href="#" onclick="'+listFunction+'('+(page+1)+', '+ query + ')">Next</a></li>');
	}
}
