$(document).ready(function() {
	
	var page = 2;
	var QUANTITY_PER_PAGE = 4;
	
	$(".btn-more-products").click(function() {
		
		var paginationData = {
			"page"            : page++,
			"quantityPerPage" : QUANTITY_PER_PAGE,
			"keyword"         : $("#keywordSearched").val()
		};
		
		$.ajax({
			  type: "POST",
			  url: "/produtos/listagem",
			  data: paginationData,
			  dataType: "json",
			  success: function(data) {
				  
				  if(data.list.length > 0) {
					  $.each(data.list, function(i, product) {
						  renderNewItem(product);
					  });
				  } 
				  if(data.list.length < 4) {
					  $('.btn-more-products').hide();
					  $('.end-list').show();
				  }
			  }
			});
	});
	
	renderNewItem = function(product) {
		
		// Fills template data
		$(".item-template .product-template-name").html(product.name);
		$(".item-template #product-template-image").attr("src", "/assets/images/"+product.imageFilename);
		$(".item-template #product-template-link").attr("href", "/produtos/"+product.id);
		$(".item-template .product-template-price").html("R$" + product.price);
		
		// Add new product in result list
		$('.product-list').append($(".item-template").html());
	};
	
});