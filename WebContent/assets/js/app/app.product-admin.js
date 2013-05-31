$(document).ready(function() {
	
	var page = 2;
	var QUANTITY_PER_PAGE = 4; 
	
	$('#price').priceFormat({
		prefix: '',
		centsSeparator: '.',
		thousandsSeparator: '',
        limit: 8,
        centsLimit: 2
    });	 
	
	$("#form-register").validate({
		
		submitHandler:function(form) {
			
			var registerData = {
				"product.id"           : $('#productId').val(),
				"product.imageFilename": $('#imageFilename').val(),
				"product.name"         : $('#name').val(),
				"product.description"  : $('#description').val(),
				"product.price"        : $('#price').val(),
				"product.status"       : $('#status').val()
			};
			
			$.ajax({
				  type: "POST",
				  url: "/produtos/salvar",
				  data: registerData,
				  dataType: "json",
				  success: function(data) {

					  var response = data.jsonViewResponse; 
					  
					  if(response.success && $("#event").val() == "REGISTER") {
						  $("#name").prop("readonly",true);
						  $("#description").prop("readonly",true);
						  $("#price").prop("readonly",true);
						  $('#status').prop('disabled', 'disabled');
						  $('#register-action').hide();
						  $('#next-step').show();
					  } else {
						  alert(response.message);
					  }
				  }
				});
		},
			
		rules: {
						
			name: {
				required: true,
				minlength: 2,
				maxlength: 150
			},
			
			description: {
				required: false,
				minlength: 5,
				maxlength: 150
			},
			
			price: {
				required: true
			}
			
		}
		
	});
	
	$(".btn-more-products").click(function() {
		
		var paginationData = {
			"page"            : page++,
			"quantityPerPage" : QUANTITY_PER_PAGE
		};
		
		$.ajax({
			  type: "POST",
			  url: "/produtos/listagem-admin",
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
		$(".item-template").addClass("item-" + product.id);
		$(".item-template .product-template-name").html(product.name);
		$(".item-template #product-template-image").attr("src", "/assets/images/"+product.imageFilename);
		$(".item-template #product-template-link").attr("href", "/produtos/"+product.id);
		$(".item-template .product-template-price").html("R$" + product.price);
		
		// Insert Edit Button
		$(".item-template .product-box").append("<a class='btn btn-warning' href='/produtos/editar/"+ product.id +"'>Editar</a>");
		
		// Add new product in result list
		$('.product-list').append($(".item-template").html());
		
		// Remove Edit Button from template
		$(".item-template .product-box .btn").remove();
		$(".item-template").removeClass("item-" + product.id);
		
	};
	
});

$(function() {
    $('#file_upload').uploadify({
        'swf'       : '/assets/js/uploadify/uploadify.swf',
        'cancelImg' : '/assets/js/uploadify/uploadify-cancel.png',
        'uploader'  : 'http://localhost:8080/produtos/novo/upload-imagem',
        'buttonText': 'Selecione a imagem',
        'auto'      : true,
        'sizeLimit' : 1024*1024, //1 MB limit
        'fileExt'   : '*.jpeg;*.gif;*.png;*.jpg;*.bmp',
        'onUploadComplete' : function(file) {
            $(".uploaded-filename").html(file.name);
            $(".upload-message").show();
        }
    });
});